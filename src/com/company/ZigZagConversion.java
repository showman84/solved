package com.company;

public class ZigZagConversion {

 /* P                       I                       N
        A               L       S               I       G
            Y       A               H       R
                P                       I
  */

//"PINALSIGYAHRPI"
//"PINALIGYAIHRNPI"

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int formula = 2 * numRows - 2 ;
        int distance =  formula;

        if (numRows <= 1)
            return s;

        for (int i =0; i < numRows; i++) {
            int local = i;
            int localDistance = distance;
            while(local < s.length()) {
                if (localDistance == 0) {
                    localDistance = formula;
                }
                sb.append(s.charAt(local));

                local = local + localDistance;
                localDistance = formula - localDistance;
            }
            distance = distance - 2;
        }
        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int magic = numRows * 2 - 2;
        int initialDistance = magic;
        for (int i = 0; i < numRows; i++) {
            fill(sb, i, initialDistance, magic, s);
            initialDistance = initialDistance - 2; //对应思路讲解第5条
        }
        return sb.toString();
    }


    public void fill(StringBuilder sb, int start, int initialDistance, int magic, String s) {
        while (start < s.length()) {
            if (initialDistance == 0)    //对应思路讲解第6条
                initialDistance = magic;
            sb.append(s.charAt(start));
            start = start + initialDistance;
            initialDistance = magic - initialDistance;//对应思路讲解第4条

        }
    }
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
    }
}
