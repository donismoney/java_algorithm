/*
 * title: 특정 문자 뒤집기
 * tier: 입문
 * url:
 */
package inflearn.string.p05;

import java.io.*;
import java.util.*;

public class Main {
	public String solution(String s) {
		String ans = "";
		int lt = 0, rt = s.length()-1;
		char[] arr = s.toCharArray();
		while(lt < rt) {
			if(Character.isAlphabetic(arr[lt]) && Character.isAlphabetic(arr[rt])) {
				char tmp =arr[lt];
				arr[lt] =arr[rt];
				arr[rt] = tmp;
				lt ++;
				rt --;
			}
			if (Character.isAlphabetic(arr[lt]) == false) {
				lt ++;
			}
			if (Character.isAlphabetic(arr[rt]) == false) {
				rt --;
			}
		}
		ans = String.valueOf(arr);
		
		return ans;
	}
    public static void main(String[] args) throws IOException{
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        sb.append(T.solution(br.readLine()));
        
        System.out.println(sb);
    }
}