/*
 * title: 문자열 압축
 * tier: 입문
 * url:
 */
package inflearn.string.p11;

import java.io.*;

public class Main {
	public String solution(String s) {
		StringBuilder res = new StringBuilder();
		s += " ";
		int cnt = 1;
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				cnt += 1;
			}
			else {
				res.append(s.charAt(i));
				if(cnt > 1) {
					res.append(cnt);
				}
				cnt = 1;
			}
		}
		
		return res.toString();
	}
	
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        sb.append(T.solution(br.readLine()));
        System.out.print(sb);
    }
}