/*
 * title: 가장 짧은 문자거리
 * tier: 입문
 * url:
 */

package inflearn.string.p10;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public int[] solution(String s, char e) {
		int[] res = new int[s.length()];
		int p = 100;
		
		for(int i = 0; i < s.length(); i++){
			char r = s.charAt(i);
			if(r == e) {
				p = 0;
			}
			else {
				p++;
			}
			res[i] = p;
		}
		for(int i = s.length()-1; i >= 0; i--){
			char r = s.charAt(i);
			if(r == e) {
				p = 0;
			}
			else {
				p++;
			}
			if(res[i] > p) {
				res[i] = p;
			}
		}		
		return res;
	}
	
    public static void main(String[] args) throws IOException {
    	Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stn = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	String s = stn.nextToken();
    	char e = stn.nextToken().charAt(0);
    	
    	int[] ans = T.solution(s, e);
    	for(int i = 0; i < ans.length; i++) {
    		sb.append(ans[i]);
    		if(i<ans.length-1) {
    			sb.append(" ");
    		}
    	}
    	
    	System.out.print(sb);
    }
    	
}