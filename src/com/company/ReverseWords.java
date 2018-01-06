package com.company;

public class ReverseWords {

    public String reverseWords(String s) {

        int sIndex = 0;
        char lastChar = 0;
        StringBuffer sb = new StringBuffer(s);
        while( sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        while (sIndex < sb.length()) {
            char ch = sb.charAt(sIndex);
            if (ch == ' ' && lastChar == ' ') {
               sb.deleteCharAt(sIndex);
            }
            else {
                sIndex++;
            }
            lastChar = ch;
        }

        while( sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        char[] chars = sb.toString().toCharArray();
        int eIndex = chars.length - 1;
        sIndex = 0;

        reverseChars(chars, sIndex, eIndex);

        eIndex = 0; sIndex = 0;

        while (eIndex < chars.length) {

            char ch = chars[eIndex];

            if (ch == ' ') {
                reverseChars(chars, sIndex, eIndex - 1);
                sIndex = eIndex + 1;
            }
            eIndex++;
        }

        if (sIndex< eIndex) {

            reverseChars(chars, sIndex, eIndex -1 );
        }

        return new String (chars);

    }

    public void reverseChars(char[] chars, int sIndex, int eIndex)
    {
        while (sIndex < eIndex) {

            char ch = chars[sIndex];
            chars[sIndex++] = chars[eIndex];
            chars[eIndex--] = ch;
        }
    }



    public static void main(String[] args) {

        System.out.println(new ReverseWords().reverseWords(""));

    }
}
