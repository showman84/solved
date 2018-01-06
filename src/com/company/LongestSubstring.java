package com.company;

import java.util.HashMap;

public class LongestSubstring {

    public String lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap();

        for(char c : s.toCharArray()) {
            map.put(c, 0);
        }

        int counter = 0, start = 0, end = 0, minLength = 0, minStart = 0;

        while (end < s.length()) {

            char c = s.charAt(end);

            if (map.get(c) > 0) {
                counter++;
            }

            map.put(c, map.get(c) + 1);

            end++;

            while (counter > 0) {
                char c2 = s.charAt(start);

                if (map.get(c2) > 1) {
                    counter--;
                }
                map.put(c2, map.get(c2) - 1);

                start++;
            }

            if (end - start > minLength) {
                minLength = end - start;
                minStart = start;
            }


        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLength);

    }

    public static void main(String[] args) {

        int A[] =  {3,4,-1,1};

        System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));

    }
}
