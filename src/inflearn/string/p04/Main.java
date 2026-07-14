/*
 * title: 단어 뒤집기
 * tier: 입문
 * url:
 */
package inflearn.string.p04;

import java.util.*;
import java.io.*;

public class Main {
    public String solution(String s){
        String ans = "";
        for(int i = s.length()-1; i >= 0; i--){
            char x = s.charAt(i);
            ans = ans + x;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            sb.append(T.solution(s));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}