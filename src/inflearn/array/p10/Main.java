/*
 * title: 봉우리
 * tier: 입문
 * url:
 */

package inflearn.array.p10;

import java.io.*;
import java.util.*;

public class Main {
	private int solution(int n, int[][] arr) {
		int res = 0;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		for(int i = 1; i <= n; i++) {
			loop1:
			for(int j = 1; j <= n; j++) {
				for(int k = 0; k < 4; k++) {
					int nextP = arr[i+dy[k]][j+dx[k]];
					if(nextP >= arr[i][j]) {
						continue loop1;
					}
				}
				res += 1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+2][N+2];
        for(int i = 1; i <= N; i++) {
        	StringTokenizer stn = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= N; j++) {
        		arr[i][j] = Integer.parseInt(stn.nextToken());
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(T.solution(N, arr));
        System.out.print(sb);
    }
}
