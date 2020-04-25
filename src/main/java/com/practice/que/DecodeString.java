package com.practice.que;

import java.util.Arrays;

public class DecodeString {
    public static void main(String[] args) {
        int[] memo = new int[4];
        Arrays.fill(memo, -1);
        System.out.println(decodeString("121", 3, memo));
    }

    public static int decodeString(String str, int k, int[] memo) {
        if (k == 0) return 1;
        if (memo[k] != -1)
            return memo[k];
        int count = 0;
        int start = str.length() - k;
        if (str.charAt(start) == '0')
            return 0;
        count = count + decodeString(str, k - 1, memo);
        if (k >= 2) {
            String s = str.substring(start, start + 2);
            Integer i = Integer.valueOf(s);
            if (i >= 10 && i <= 26)
                count = count + decodeString(str, k - 2, memo);
        }
        memo[k] = count;
        return count;
    }
}
