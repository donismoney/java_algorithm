/*
 * title: 숫자만 추출
 * tier: 입문
 * url:
 */


package inflearn.string.p09;

import java.io.*;

public class Main {
	public int solution(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) == true) {
				res += s.charAt(i);
			}
		}
		int ans = Integer.parseInt(res);
		return ans;
	}
	
    public static void main(String[] args) throws IOException {
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(T.solution(br.readLine()));
    	System.out.print(sb);
    }
}