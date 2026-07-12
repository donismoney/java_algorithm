package inflearn.string.p02;

import java.util.Scanner;

class Main {
    public String solution(String s) {
        String answer = new String();
        
        for(int i=0; i < s.length(); i++) {
        	if(Character.isUpperCase(s.charAt(i))) {
        		answer += Character.toLowerCase(s.charAt(i));
        	}
        	else {
        		answer += Character.toUpperCase(s.charAt(i));
        	}
        }
        return answer;
    }
    public static void main(String[] args) {
		Main T = new Main();
    	Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(T.solution(s));
	}
}