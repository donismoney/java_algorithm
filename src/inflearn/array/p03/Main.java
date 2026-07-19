/*
 * title: 가위바위보
 * tier: 입문
 * url:
 */

package inflearn.array.p03;

import java.util.*;
import java.io.*;

public class Main {
	public String solution(int n, int[] arr, int[] brr) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			if (arr[i] == brr[i]) {
				sb.append('D').append('\n');
			}
			else if (
					arr[i] == 1 && brr[i] == 3 ||
					arr[i] == 2 && brr[i] == 1 ||
					arr[i] == 3 && brr[i] == 2) {
				sb.append('A').append('\n');
			}
			else {
				sb.append('B').append('\n');
			}
		}

		return sb.toString();
	}
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] brr = new int[N];
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(stn.nextToken());
        }
        stn = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	brr[i] = Integer.parseInt(stn.nextToken());
        }
        
        sb.append(T.solution(N, arr, brr));
        System.out.print(sb);
    }
}