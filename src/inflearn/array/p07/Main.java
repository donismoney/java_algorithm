/*
 * title: 점수 계산
 * tier: 입문
 * url:
 */

package inflearn.array.p07;

import java.util.*;
import java.io.*;

public class Main {
	public int solution(int[] arr) {
		int res = 0;
		int plusPoint = 1;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				res += plusPoint;
				plusPoint++;
			}
			else {
				plusPoint = 1;
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
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(stn.nextToken());
        }
        
        sb.append(T.solution(arr));
        System.out.print(sb);
    }
}