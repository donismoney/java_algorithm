/*
 * title: 문장 속 단어
 * tier: 입문
 * url:
 */
package inflearn.string.p03;

import java.io.*;
import java.util.*;

public class Main {
    public String solution(String s){
        String ans = "";
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()){
            String word = st.nextToken();
            if(ans.length() < word.length()){
                ans = word;
            }
        }

        return  ans;
    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        sb.append(T.solution(s));
        System.out.println(sb);
    }
}