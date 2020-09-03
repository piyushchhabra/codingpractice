package com.practice.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWIthoutRepeating {

    public int lengthOfLongestSubstring(String A) {
        Map<Character, Integer> visited = new HashMap<>();
        int start =0;
        String output="";
        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if(visited.containsKey(c)) {
                start =  Math.max(start, visited.get(c) + 1);
            }
            if(i-start+1 > output.length()) {
                output = A.substring(start, i+1);
            }
            visited.put(c, i);
        }
        return output.length();
    }
}
