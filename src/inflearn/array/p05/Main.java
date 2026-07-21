/*
 * title: 소수(에라토스테네스 체)
 * tier: 입문
 * url:
 */

package inflearn.array.p05;

import java.io.*;

public class Main {
	public int solution(int n) {
		int res = 0;
		int[] ch = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(ch[i] == 0) {
				res += 1;
				for(int j = i; j <= n; j += i) {
					ch[j] = 1;
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		sb.append(T.solution(N));
		System.out.print(sb);
	}
}

