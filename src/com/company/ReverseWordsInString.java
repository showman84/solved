package com.company;

public class ReverseWordsInString {

    //Given s = "the sky is blue",
    // return "blue is sky the".

    public String reverseWords(String s) {

        int sIndex = 0;
        int eIndex = s.length() - 1;
        char ch[] = s.toCharArray();
        reverse(ch, sIndex, eIndex);
        eIndex = 0;
        sIndex = 0;
        while (eIndex < s.length() - 1) {
            char c = ch[eIndex];
            if (c == ' ') {
                reverse(ch, sIndex, eIndex - 1);
                sIndex = eIndex + 1;
            }
            eIndex++;
        }
        if (sIndex < eIndex) {
            reverse(ch, sIndex, eIndex );
        }
        return new String(ch);
    }

    public void reverse(char[] ch, int sIndex, int eIndex) {
        while ( sIndex < eIndex) {
            char c = ch[sIndex];
            ch[sIndex] = ch[eIndex];
            ch[eIndex] = c;
            sIndex++;
            eIndex--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
    }
}
