/*
 * title: 등수 구하기
 * tier: 입문
 * url:
 */

package inflearn.array.p08;

import java.io.*;
import java.util.*;

public class Main {
	public int[] solution(int n, int[] arr) {
		int[] res = new int[n];
		int[] sortArr = arr.clone();
		Arrays.sort(sortArr);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i = n-1; i >= 0; i--) {
			hm.putIfAbsent(sortArr[i], n-i);
		}
		
		for(int i = 0; i < n; i++) {
			res[i] = hm.get(arr[i]);
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
        
        int[] ans = T.solution(N, arr);
        for(int x: ans) {
        	if (sb.length() > 0) {
        		sb.append(' ');
        	}
        	sb.append(x);
        }
        System.out.print(sb);
    }
}
