/*
 * title: 큰 수 출력하기
 * tier: 입문
 * url:
 */

package inflearn.array.p01;

import java.io.*;
import java.util.*;


public class Main {
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				res.add(arr[i]);
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
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(stn.nextToken());
        }
        
        for(int v:T.solution(N, arr)) {
        	sb.append(v).append(" ");
        }
        System.out.print(sb);
    }
}