/*
 * title: 보이는 학생
 * tier: 입문
 * url:
 */

package inflearn.array.p02;

import java.util.*;
import java.io.*;

public class Main {
	public int solution(int n, int[] arr) {
		int res = 1;
		int prev_max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > prev_max) {
				prev_max = arr[i];
				res += 1;
			}
		}
		
		return res;
	}
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(stn.nextToken());
        }
        
        sb.append(T.solution(N, arr));
        System.out.print(sb);
    }
}