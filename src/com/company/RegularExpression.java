package com.company;

public class RegularExpression {

    public boolean isMatch(String text, String pattern) {

        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean firstCharMatched = false;

        if (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
            firstCharMatched = true;
        }

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (firstCharMatched && isMatch(text.substring(1), pattern) || isMatch(text, pattern.substring(2)));

        }
        else {

            return firstCharMatched && isMatch(text.substring(1), pattern.substring(1));
        }

    }

    public static void main(String[] args) {



     /*   System.out.println(new RegularExpression().isMatch("aa","a"));
        System.out.println(new RegularExpression().isMatch("aa","aa"));
        System.out.println(new RegularExpression().isMatch("aaa","aa"));
        System.out.println(new RegularExpression().isMatch("aa","a*"));
        System.out.println(new RegularExpression().isMatch("aa",".*"));
        System.out.println(new RegularExpression().isMatch("ab",".*"));
        System.out.println(new RegularExpression().isMatch("aab","c*a*b"));
        System.out.println(new RegularExpression().isMatch("ab",".*c"));*/
        System.out.println(new RegularExpression().isMatch("baa","b*aa"));


    }
}
