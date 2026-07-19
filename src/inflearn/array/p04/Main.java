/*
 * title: 피보나치 수열
 * tier: 입문
 * url:
 */

package inflearn.array.p04;

import java.io.*;
import java.util.*;

public class Main {
	public int[] solution(int n) {
		int[] res = new int[n];
		res[0] = 1;
		res[1] = 1;
		for(int i = 2; i < n; i++) {
			res[i] = res[i-1] + res[i-2];
		}
		
		return res;
	}
	
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] ans = T.solution(N);
        for(int i = 0; i < ans.length; i++) {
        	sb.append(ans[i]).append(' ');
        }
        System.out.print(sb);
    }
}