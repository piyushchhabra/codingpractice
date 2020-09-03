package com.practice.codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.codechef.com/MAY20B/problems/CORUS
public class Corus {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();
            while (test-- > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();
                String str = sc.next();
                Map<Character, Integer> map = new HashMap<>();
                for(char c : str.toCharArray()) {
                    map.putIfAbsent(c, 0);
                    map.put(c, map.get(c)+1);
                }
                while(q-- > 0) {
                    int centers = sc.nextInt();
                    System.out.println(getForQuery(map, centers));
                }
            }
        } catch (Exception e) {
            return;
        }
    }

    private static int getForQuery(Map<Character, Integer> frequency, int centers) {
        int res = 0;
        for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if(entry.getValue() > centers)
                res += entry.getValue()-centers;
        }
        return res;
    }
}
