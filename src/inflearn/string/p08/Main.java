/*
 * title: 유효한 팰린드롬
 * tier: 입문
 * url:
 */

package inflearn.string.p08;

import java.io.*;

public class Main {
	public String solution(String s) {
		String res = "YES";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(s).reverse().toString();
		for(int i = 0; i < s.length()/2; i++)
			if(s.charAt(i) != tmp.charAt(i)) {
				res = "NO";
				break;
			}
		
		return res;
	}
	
    public static void main(String[] args) throws IOException {
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(T.solution(br.readLine()));
    	System.out.print(sb);
    }
}