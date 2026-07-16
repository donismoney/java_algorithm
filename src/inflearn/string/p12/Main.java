/*
 * title: 암호
 * tier: 입문
 * url:
 */
package inflearn.string.p12;

import java.io.*;

public class Main {
	public String solution(int n, String s) {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String s_bianry = s.substring(i*7, i*7+7);
			s_bianry = s_bianry.replace('*', '0').replace('#', '1');
			int i_binary = Integer.parseInt(s_bianry, 2);
			res.append(Character.toChars(i_binary));		
		}
		
		return res.toString();
	}
	
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        sb.append(T.solution(n, s));
        System.out.print(sb);
    }
}