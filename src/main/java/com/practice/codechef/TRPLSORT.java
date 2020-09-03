package com.practice.codechef;

import lombok.Data;

import java.util.Optional;

public class TRPLSORT {
    public static void main(String[] args) {
        String res = getString().orElseGet( () -> test("backup"));
        System.out.println(res);
    }

    @Data
    static class Test {
        private String str;

        public Test(String s) {
            this.str = s;
        }
    }

    private static Optional<String> getString() {
        return Optional.of("lele");
    }

    private static String test(String test) {
        System.out.println(test);
        return test;
    }

}
