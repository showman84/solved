package com.company;

public class LongestPalindrome {

    int maxLength = 0;
    int maxLenthStartIndex = 0;

    public String longestPalindrome(String s) {
        //"babad"
        int index = 0;

        while (index < s.length()) {
            int forwardIndex = index, back = index - 1;
            checkPalindrome(s, back, forwardIndex);
            checkPalindrome(s, back, forwardIndex + 1);
            index++;
        }
        return s.substring(maxLenthStartIndex, maxLenthStartIndex + maxLength + 1);
    }
    public void checkPalindrome(String s, int back, int forwardIndex) {
        while (back >= 0 && forwardIndex < s.length()
                && (s.charAt(back) == s.charAt(forwardIndex) || s.charAt(back) == s.charAt(forwardIndex))) {
            if (forwardIndex - back > maxLength) {
                maxLength = forwardIndex - back;
                maxLenthStartIndex = back;
            }
            back--;
            forwardIndex++;
        }
    }

    public static void main(String[] args) {

        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
    }
}
