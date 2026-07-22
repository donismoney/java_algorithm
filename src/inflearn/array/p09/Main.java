/*
 * title: 격자판 최대 합
 * tier: 입문
 * url:
 */

package inflearn.array.p09;

import java.io.*;
import java.util.*;

public class Main {
	public int solution(int n, int[][] arr) {
		int res = 0;
		int dia1 = 0;
		int dia2 = 0;
		
		for(int i = 0; i < n; i++) {
			int col = 0;
			int row = 0;
			
			for(int j = 0; j < n; j++) {
				row += arr[i][j];
				col += arr[j][i];
			}
			res = Math.max(res, Math.max(col, row));
			
			dia1 += arr[i][i];
			dia2 += arr[i][n-1-i];
		}
		res = Math.max(res, Math.max(dia1, dia2));
		
		return res;
	}
	
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
        	StringTokenizer stn = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(stn.nextToken());
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(T.solution(N, arr));
        
    	System.out.print(sb);
    }
}