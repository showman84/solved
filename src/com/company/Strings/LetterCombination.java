package com.company.Strings;

import com.company.Arrays.RotateArray;

import java.util.*;

public class LetterCombination {

    public LetterCombination() {


    }


    public List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap();
        map.put('1',"1");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0',"0");

        //23
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        int index = 0;

        while (index < digits.length()) {
            char c = digits.charAt(index);
            if (map.containsKey(c)) {
                String str = map.get(c);
                List<String> list = new ArrayList(result);
                if (list.isEmpty()) {
                    for (char charInStr : str.toCharArray()) {
                        result.add(""+ charInStr);
                    }
                }
                else {
                    for (String s : list) {
                        result.remove(s);
                        for (char charInStr : str.toCharArray()) {
                            result.add(s + charInStr);
                        }
                    }
                }
            }
            index++;
        }

        return result;
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations1(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }


    public static void main(String[] args) {

        System.out.println(new LetterCombination().letterCombinations1("23"));
    }
}
