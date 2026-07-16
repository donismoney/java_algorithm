/*
 * title: 회문 문자열
 * tier: 입문
 * url:
 */

package inflearn.string.p07;

import java.io.*;

public class Main {
	public String solution(String s) {
		String res = "YES";
		String S = s.toUpperCase();
		int lt = 0, rt = S.length()-1;
		char[] arr = S.toCharArray();
		while(lt < rt) {
			if(arr[lt] == arr[rt]) {
				lt ++;
				rt --;
			}
			else {
				res = "NO";
				break;
			}
		}
		return res;
	}
	
    public static void main(String[] args) throws IOException {
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(T.solution(br.readLine()));
    	System.out.println(sb);
    }
}