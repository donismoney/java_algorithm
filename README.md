# Java Algorithm

Java 코딩테스트 문제 풀이 및 알고리즘 학습 기록입니다.

## 문제 출처

<!-- AUTO-SOURCES:START -->

- 인프런

<!-- AUTO-SOURCES:END -->

## 저장 규칙

```text
src/출처/알고리즘유형/문제번호/Main.java
```

예시:

```text
src/inflearn/string/p01/Main.java
src/baekjoon/dfsbfs/b2606/Main.java
src/programmers/stackqueue/p42586/Main.java
```

## 알고리즘 분류 및 문제 풀이 목록

<!-- AUTO-GENERATED:START -->

총 **22문제**

<details>
<summary><strong>문자열 — 12문제</strong></summary>

| 유형 | 티어 | 문제 | 출처 | 풀이 | Comment |
| :---: | :---: | :--- | :---: | :---: | :---: |
| 문자열 | 입문 | 문자 찾기 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p01/Main.java) | 입력 문자열에서 특정 문자의 등장 횟수 계산<br>문자열과 대상 문자를 대문자로 변환해 대소문자 구분 없이 비교<br>Scanner를 사용해 문자열과 문자를 입력받도록 구현 |
| 문자열 | 입문 | 대소문자 변환 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p02/Main.java) | 문자열의 각 문자가 대문자인지 확인<br>대문자는 소문자로, 소문자는 대문자로 변환<br>Character 클래스의 대소문자 판별 및 변환 메서드 활용 |
| 문자열 | 입문 | 문장 속 단어 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p03/Main.java) | StringTokenizer로 문장을 단어 단위로 분리하고 각 단어의 길이를 비교하도록 구현했다.<br>길이가 같은 경우 먼저 등장한 단어가 유지되도록 처리했다. |
| 문자열 | 입문 | 단어 뒤집기 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p04/Main.java) | 문자열의 마지막 인덱스부터 첫 인덱스까지 역순으로 순회해 각 단어를 뒤집도록 구현했다.<br>여러 단어의 결과는 StringBuilder에 누적해 한 번에 출력한다. |
| 문자열 | 입문 | 특정 문자 뒤집기 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p05/Main.java) | 투 포인터를 사용해 양쪽 문자가 모두 알파벳일 때만 서로 교환하도록 구현했다.<br>특수문자를 만나면 해당 포인터만 이동시켜 특수문자의 기존 위치를 유지하도록 처리했다. |
| 문자열 | 입문 | 중복 문자 제거 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p06/Main.java) | 각 문자의 현재 인덱스와 indexOf로 찾은 최초 등장 인덱스를 비교하도록 구현했다.<br>처음 등장한 문자만 결과에 추가해 기존 순서를 유지하면서 중복 문자를 제거했다. |
| 문자열 | 입문 | 회문 문자열 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p07/Main.java) | 입력 문자열을 대문자로 변환해 대소문자 차이를 제거했다.<br>양 끝을 가리키는 두 포인터를 안쪽으로 이동하며 문자를 비교해 회문 여부를 판별했다. |
| 문자열 | 입문 | 유효한 팰린드롬 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p08/Main.java) | 입력 문자열을 대문자로 변환하고 정규식을 사용해 알파벳이 아닌 문자를 제거했다.<br>전처리한 문자열과 뒤집은 문자열의 문자를 절반까지 비교해 팰린드롬 여부를 판별했다. |
| 문자열 | 입문 | 숫자만 추출 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p09/Main.java) | 문자열을 순회하며 Character.isDigit()으로 숫자인 문자만 추출했다.<br>추출한 숫자 문자열을 Integer.parseInt()로 정수로 변환해 앞쪽의 0이 제거된 결과를 반환했다. |
| 문자열 | 입문 | 가장 짧은 문자거리 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p10/Main.java) | 문자열을 왼쪽에서 오른쪽으로 순회하며 각 문자와 왼쪽에 있는 대상 문자 사이의 거리를 저장했다.<br>오른쪽에서 왼쪽으로 다시 순회해 오른쪽 대상 문자와의 거리를 계산하고, 기존 값과 비교해 더 짧은 거리를 유지했다. |
| 문자열 | 입문 | 문자열 압축 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p11/Main.java) | 문자열의 인접한 문자를 비교하며 같은 문자가 연속으로 등장한 횟수를 계산했다.<br>문자가 달라지는 시점에 문자와 반복 횟수를 StringBuilder에 추가하고, 한 번만 등장한 문자는 횟수를 생략했다. |
| 문자열 | 입문 | 암호 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/string/p12/Main.java) | 암호 문자열을 문자 하나당 일곱 자리씩 분리하고 #은 1, *은 0으로 변환했다.<br>변환한 이진 문자열을 Integer.parseInt(..., 2)로 십진수화한 뒤 해당 유니코드 문자로 변환해 결과를<br>완성했다. |

</details>

<details>
<summary><strong>배열 — 10문제</strong></summary>

| 유형 | 티어 | 문제 | 출처 | 풀이 | Comment |
| :---: | :---: | :--- | :---: | :---: | :---: |
| 배열 | 입문 | 큰 수 출력하기 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p01/Main.java) | 첫 번째 수는 항상 결과에 포함하고, 두 번째 수부터 바로 앞의 수와 비교했다.<br>현재 수가 이전 수보다 큰 경우에만 ArrayList에 추가해 조건을 만족하는 수를 출력했다. |
| 배열 | 입문 | 보이는 학생 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p02/Main.java) | 첫 번째 학생의 키를 초기 최댓값으로 설정하고 보이는 학생 수를 1로 초기화했다.<br>배열을 순회하며 현재까지의 최댓값보다 키가 큰 학생을 발견할 때마다 최댓값과 학생 수를 갱신했다. |
| 배열 | 입문 | 가위바위보 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p03/Main.java) | A와 B가 낸 값을 같은 인덱스끼리 비교해 각 회차의 승패를 판별했다.<br>두 값이 같으면 D를 출력하고, A가 이기는 세 가지 조합을 조건식으로 처리해 나머지는 B의 승리로 구분했다. |
| 배열 | 입문 | 피보나치 수열 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p04/Main.java) | 첫 번째와 두 번째 항을 1로 초기화하고, 이전 두 항의 합을 이용해 이후 항을 순차적으로 계산했다.<br>계산한 수열을 정수 배열에 저장해 반환하고, 반환된 배열을 순회하며 공백으로 구분해 출력했다. |
| 배열 | 입문 | 소수(에라토스테네스 체) | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p05/Main.java) | 에라토스테네스의 체를 이용해 아직 합성수로 표시되지 않은 수를 소수로 판별했다.<br>소수를 발견할 때마다 개수를 증가시키고, 해당 수의 배수를 배열에 표시해 이후 검사에서 제외했다. |
| 배열 | 입문 | 뒤집은 소수 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p06/Main.java) | 각 자연수의 마지막 자릿수를 반복적으로 추출해 숫자를 역순으로 뒤집었다.<br>뒤집은 수를 제곱근 범위까지 나누어 소수 여부를 판별하고, 소수인 값만 입력 순서대로 결과에 추가했다. |
| 배열 | 입문 | 점수 계산 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p07/Main.java) | 정답이 연속될 때마다 가산점을 1씩 증가시켜 해당 문제의 점수에 반영했다.<br>오답이 나오면 가산점을 1로 초기화하고, 각 문제에서 획득한 점수를 누적해 총점을 계산했다. |
| 배열 | 입문 | 등수 구하기 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p08/Main.java) | 원본 점수 배열을 복사해 오름차순으로 정렬하고, 높은 점수부터 순회하며 점수별 등수를 HashMap에 저장했다.<br>같은 점수는 putIfAbsent로 가장 높은 등수를 유지하고, 원본 배열 순서대로 등수를 조회해 결과를 구성했다. |
| 배열 | 입문 | 격자판 최대 합 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p09/Main.java) | 각 행과 열을 순회하며 합을 계산하고, Math.max를 이용해 현재 최대합을 갱신했다.<br>주대각선과 반대 대각선의 합을 함께 누적한 뒤 행·열의 최대합과 비교해 최종 결과를 구했다. |
| 배열 | 입문 | 봉우리 | 인프런 | [풀이](https://github.com/donismoney/java_algorithm/blob/main/src/inflearn/array/p10/Main.java) | 격자판 외곽을 0으로 패딩하고 방향 배열을 이용해 각 지점의 상하좌우 값을 검사했다.<br>주변 값 중 현재 값보다 크거나 같은 값이 있으면 라벨 continue로 다음 지점으로 이동하고, 네 방향보다 모두 큰 지점만<br>봉우리로 집계했다. |

</details>

<!-- AUTO-GENERATED:END -->