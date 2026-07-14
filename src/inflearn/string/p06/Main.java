/*
 * title: 중복 문자 제거
 * tier: 입문
 * url:
 */
package inflearn.string.p06;

import java.io.*;
import java.util.*;

public class Main {
	public String solution(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == i) {
				res += s.charAt(i);
			}
		}
		
		return res;
	}
    public static void main(String[] args) throws IOException{
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(T.solution(br.readLine()));
    	System.out.println(sb);
    }
}