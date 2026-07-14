from __future__ import annotations

import os
import re
import subprocess
from dataclasses import dataclass
from pathlib import Path
from typing import Iterable


# scripts/generate_readme.py의 상위 프로젝트 폴더
ROOT = Path(__file__).resolve().parents[1]

SRC_DIR = ROOT / "src"
README_PATH = ROOT / "README.md"

START_MARKER = "<!-- AUTO-GENERATED:START -->"
END_MARKER = "<!-- AUTO-GENERATED:END -->"


# src 바로 아래 폴더 이름과 README 표시 이름
SOURCE_NAMES = {
    "inflearn": "인프런",
    "baekjoon": "백준",
    "programmers": "프로그래머스",
    "swea": "SWEA",
}

SOURCE_ORDER = {
    name: index
    for index, name in enumerate(SOURCE_NAMES)
}


# 알고리즘 패키지명과 README 표시 이름
CATEGORY_NAMES = {
    "string": "문자열",
    "array": "배열",
    "implementation": "구현",
    "bruteforce": "브루트포스",
    "twopointer": "투 포인터",
    "slidingwindow": "슬라이딩 윈도우",
    "hash": "해시",
    "stackqueue": "스택·큐",
    "sorting": "정렬",
    "binarysearch": "이분 탐색",
    "dfsbfs": "DFS·BFS",
    "backtracking": "백트래킹",
    "greedy": "그리디",
    "dp": "동적 계획법",
    "graph": "그래프",
    "shortestpath": "최단 경로",
    "mst": "최소 신장 트리",
    "unionfind": "유니온 파인드",
    "divideconquer": "분할 정복",
}

CATEGORY_ORDER = list(CATEGORY_NAMES)


# Main.java 상단의 메타데이터를 읽는 정규식
METADATA_PATTERN = re.compile(
    r"^\s*\*?\s*(title|tier|url)\s*:\s*(.*?)\s*$",
    re.MULTILINE | re.IGNORECASE,
)


@dataclass(frozen=True)
class GitInfo:
    sha: str
    date: str
    subject: str
    body: str


@dataclass(frozen=True)
class Problem:
    source_key: str
    category_key: str
    problem_id: str

    title: str
    tier: str
    url: str

    code_path: str
    git: GitInfo


def run_git(*args: str) -> str:
    """
    현재 저장소에서 Git 명령어를 실행하고 표준 출력을 반환한다.
    """
    result = subprocess.run(
        ["git", *args],
        cwd=ROOT,
        text=True,
        encoding="utf-8",
        errors="replace",
        capture_output=True,
        check=False,
    )

    return result.stdout.strip()


def get_repository_url() -> str:
    """
    GitHub Actions에서는 GITHUB_REPOSITORY를 사용하고,
    로컬 실행에서는 origin 주소를 사용한다.
    """
    repository = os.getenv("GITHUB_REPOSITORY", "").strip()

    if repository:
        return f"https://github.com/{repository}"

    remote = run_git("remote", "get-url", "origin")

    if remote.startswith("git@github.com:"):
        remote = (
            "https://github.com/"
            + remote.removeprefix("git@github.com:")
        )

    if remote.startswith("ssh://git@github.com/"):
        remote = (
            "https://github.com/"
            + remote.removeprefix("ssh://git@github.com/")
        )

    return remote.removesuffix(".git")


def parse_metadata(java_file: Path) -> dict[str, str]:
    """
    Main.java의 다음 항목을 읽는다.

    title:
    tier:
    url:
    """
    text = java_file.read_text(encoding="utf-8")

    return {
        key.lower(): value.strip()
        for key, value in METADATA_PATTERN.findall(text)
    }


def get_first_commit(relative_path: str) -> GitInfo:
    """
    파일을 최초로 추가한 커밋의 정보를 가져온다.

    - 커밋 SHA
    - 날짜
    - 커밋 제목
    - 커밋 본문
    """
    output = run_git(
        "log",
        "--follow",
        "--diff-filter=A",
        "--date=short",
        "--format=%H%x1f%ad%x1f%s%x1f%b%x1e",
        "--",
        relative_path,
    )

    records = [
        record.strip()
        for record in output.split("\x1e")
        if record.strip()
    ]

    if not records:
        return GitInfo(
            sha="",
            date="미커밋",
            subject="",
            body="",
        )

    # git log는 최신 기록부터 출력한다.
    # 파일이 삭제 후 재등록된 경우 가장 오래된 추가 커밋을 사용한다.
    parts = records[-1].split("\x1f", 3)

    parts += [""] * (4 - len(parts))

    return GitInfo(
        sha=parts[0],
        date=parts[1],
        subject=parts[2],
        body=parts[3].strip(),
    )


def natural_key(value: str) -> list[object]:
    """
    p2가 p10보다 먼저 나오도록 자연 정렬한다.
    """
    return [
        int(part) if part.isdigit() else part.lower()
        for part in re.split(r"(\d+)", value)
    ]


def escape_markdown(value: str) -> str:
    """
    Markdown 표를 깨뜨릴 수 있는 문자를 이스케이프한다.
    """
    return (
        value
        .replace("\\", "\\\\")
        .replace("|", "\\|")
        .replace("[", "\\[")
        .replace("]", "\\]")
    )


def format_comment(git: GitInfo) -> str:
    """
    Comment 작성 규칙:

    1. 커밋 본문이 있으면 본문 사용
    2. 본문이 없으면 커밋 제목 사용
    3. 하이퍼링크를 만들지 않고 일반 텍스트로 표시
    """
    raw = (
        git.body.strip()
        or git.subject.strip()
        or "-"
    )

    lines: list[str] = []

    for line in raw.splitlines():
        line = line.strip()

        # "- 설명", "* 설명" 형태에서 목록 기호 제거
        line = re.sub(
            r"^[-*]\s+",
            "",
            line,
        )

        if line:
            lines.append(
                escape_markdown(line)
            )

    if not lines:
        return "-"

    # Markdown 표 안에서 여러 줄을 표시하기 위해 <br> 사용
    return "<br>".join(lines)

def format_code_link(
    problem: Problem,
    repository_url: str,
) -> str:
    """
    GitHub 저장소의 Main.java 파일로 이동하는 풀이 링크를 생성한다.
    """
    if repository_url:
        code_url = (
            f"{repository_url}/blob/main/"
            f"{problem.code_path}"
        )

        return f"[풀이]({code_url})"

    # 원격 저장소 주소를 확인할 수 없는 경우 상대경로 사용
    return f"[풀이](./{problem.code_path})"

def discover_problems() -> list[Problem]:
    """
    다음 규칙의 Java 파일을 검색한다.

    src/출처/알고리즘/문제번호/Main.java
    """
    if not SRC_DIR.exists():
        return []

    problems: list[Problem] = []
    errors: list[str] = []

    for java_file in sorted(
        SRC_DIR.glob("*/*/*/Main.java")
    ):
        relative = java_file.relative_to(ROOT)
        parts = relative.parts

        source_key = parts[1]
        category_key = parts[2]
        problem_id = parts[3]

        metadata = parse_metadata(java_file)

        title = metadata.get(
            "title",
            "",
        ).strip()

        if not title:
            errors.append(
                f"{relative.as_posix()}: "
                "title 메타데이터가 없습니다."
            )
            continue

        problem = Problem(
            source_key=source_key,
            category_key=category_key,
            problem_id=problem_id,

            title=title,
            tier=(
                metadata.get("tier", "-")
                or "-"
            ),
            url=metadata.get("url", ""),

            code_path=relative.as_posix(),
            git=get_first_commit(
                relative.as_posix()
            ),
        )

        problems.append(problem)

    if errors:
        raise ValueError(
            "\n".join(errors)
        )

    return problems


def problem_link(problem: Problem) -> str:
    """
    URL이 있으면 문제명을 링크로 만들고,
    URL이 없으면 문제명만 표시한다.
    """
    title = escape_markdown(problem.title)

    if problem.url:
        return f"[{title}]({problem.url})"

    return title


def generate_section(
    problems: Iterable[Problem],
) -> str:
    """
    README 자동 생성 영역을 만든다.
    """
    repository_url = get_repository_url()
    problems = list(problems)

    grouped: dict[str, list[Problem]] = {}

    for problem in problems:
        grouped.setdefault(
            problem.category_key,
            [],
        ).append(problem)

    # CATEGORY_NAMES에 아직 등록하지 않은 새 유형도 표시한다.
    unknown_categories = sorted(
        set(grouped)
        - set(CATEGORY_ORDER)
    )

    category_keys = [
        *CATEGORY_ORDER,
        *unknown_categories,
    ]

    lines = [
        f"총 **{len(problems)}문제**",
        "",
    ]

    for category_key in category_keys:
        items = grouped.get(
            category_key,
            [],
        )

        # 풀이가 없는 유형은 README에 표시하지 않는다.
        if not items:
            continue

        items.sort(
            key=lambda item: (
                SOURCE_ORDER.get(
                    item.source_key,
                    len(SOURCE_ORDER),
                ),
                natural_key(
                    item.problem_id
                ),
            )
        )

        category_name = CATEGORY_NAMES.get(
            category_key,
            category_key,
        )

        lines.extend(
            [
                "<details>",
                (
                    "<summary><strong>"
                    f"{category_name} — "
                    f"{len(items)}문제"
                    "</strong></summary>"
                ),
                "",
                (
                    "| 유형 | 티어 | 문제 | 출처 | "
                    "풀이 | Comment |"
                ),
                (
                    "| :---: | :---: | :--- | :---: | "
                    ":---: | :---: |"
                ),
            ]
        )

        for problem in items:
            source_name = SOURCE_NAMES.get(
                problem.source_key,
                problem.source_key,
            )

            code_link = format_code_link(
                problem,
                repository_url,
            )

            comment = format_comment(
                problem.git,
            )

            row = [
                category_name,
                escape_markdown(problem.tier),
                problem_link(problem),
                source_name,
                code_link,
                comment,
            ]

            lines.append(
                "| "
                + " | ".join(row)
                + " |"
            )

        lines.extend(
            [
                "",
                "</details>",
                "",
            ]
        )

    if not problems:
        lines.append(
            "아직 등록된 문제가 없습니다."
        )

    return "\n".join(lines).rstrip()


def update_readme(generated: str) -> None:
    """
    README의 두 마커 사이만 교체한다.
    """
    if not README_PATH.exists():
        raise FileNotFoundError(
            "README.md 파일을 찾을 수 없습니다."
        )

    readme = README_PATH.read_text(
        encoding="utf-8"
    )

    if (
        START_MARKER not in readme
        or END_MARKER not in readme
    ):
        raise ValueError(
            "README.md에 자동 생성 마커가 없습니다.\n"
            f"{START_MARKER}\n"
            f"{END_MARKER}"
        )

    before, remainder = readme.split(
        START_MARKER,
        1,
    )

    _, after = remainder.split(
        END_MARKER,
        1,
    )

    updated = (
        before.rstrip()
        + "\n\n"
        + START_MARKER
        + "\n\n"
        + generated
        + "\n\n"
        + END_MARKER
        + after
    )

    README_PATH.write_text(
        updated,
        encoding="utf-8",
        newline="\n",
    )


def main() -> None:
    problems = discover_problems()

    generated = generate_section(
        problems
    )

    update_readme(generated)

    print(
        "README.md 갱신 완료: "
        f"{len(problems)}문제"
    )


if __name__ == "__main__":
    main()