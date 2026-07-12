package inflearn.string.p01;

import java.util.*;

public class Main {
    public int solution(String s, char c) {
        int cnt = 0;
        s = s.toUpperCase();
        c = Character.toUpperCase(c);

        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == c) {
        		cnt += 1;
        	}
        }
        return cnt;
    }
    
    public static void main(String[] args) {
    	Main T = new Main();
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char c = input.next().charAt(0);
        
        System.out.println(T.solution(s, c));
    }
}