package com.company;

import java.util.HashMap;

public class minWindow {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c: s.toCharArray()) {
            map.put(c, 0);
        }
        for (char c: t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        int start = 0, end = 0, length = s.length(), counter = t.length(), minLength = Integer.MAX_VALUE, minStart = 0;

        while (end < length) {

            char c = s.charAt(end++);

            if (map.get(c) > 0) {
                counter--;
            }

            map.put(c, map.get(c) - 1);

            while (counter == 0) {
                if(end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }

                c = s.charAt(start++);
                map.put(c, map.get(c) + 1);
                if (map.get(c) > 0) {
                    counter++;
                }
            }
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);

    }

    public static void main(String[] args) {
        System.out.println(new minWindow().minWindow("ADOBECODEBANC", "ABC"));

    }
}
