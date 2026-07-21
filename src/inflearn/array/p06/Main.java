/*
 * title: 뒤집은 소수
 * tier: 입문
 * url:
 */

package inflearn.array.p06;

import java.io.*;
import java.util.*;

public class Main {
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			int x = reverse_num(arr[i]);
			if(isPrime(x)) {
				res.add(x);
			}
		}
		
		return res;
	}

	private int reverse_num(int a) {
		int res_rn = 0;
		
		while(a > 0) {
			res_rn = res_rn * 10 + a%10;
			a = a/10;
		}
		
		return res_rn;
	}
	
	private boolean isPrime(int b) {
		if(b <= 1) {
			return false;
		}
		
		boolean res_b = true;
		for(int i=2; i*i <= b; i++) {
			if(b%i == 0) {
				res_b = false;
				break;
			}
		}
		
		return res_b;
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
        
        ArrayList<Integer> ans = T.solution(N, arr);
        for(int x:ans) {
        	if(sb.length() > 0) {
        		sb.append(' ');
        	}
        	sb.append(x);
        }
        
        System.out.print(sb);
    }
}
