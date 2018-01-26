package com.company.Strings;

public class DecodeWays {

    public int numDecodingsDP(String s) {

        if (s== null || s.length() == 0)
            return 0;

        int nums[] = new int[s.length() + 1];


        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {

            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            if(first >= 1 && first <= 9) {
                nums[i] += nums[i-1];
            }
            if(second >= 10 && second <= 26) {
                nums[i] += nums[i-2];
            }

        }

        return nums[s.length()];

    }

    public int numDecodings(String s) {

        if (s== null || s.length() == 0 )
            return 0;

        if (s.length() == 1 && s != "0")
            return 1;

        int first = Integer.valueOf(s.substring(s.length() - 1 , s.length()));

        int second = Integer.valueOf(s.substring(s.length() > 2 ? s.length() - 2 : 0, s.length()));

        int count = 0;

        if(first > 0) {
            count = numDecodings(s.substring( 0, s.length() - 1));
        }


        if(second > 9 && second < 27) {
            count += numDecodings(s.substring(0,  s.length() - 2));
        }
        return count;

    }



    public int mapping(String c) {

        int cIntValue = Integer.valueOf(c);
        return 'A' + (cIntValue -1);
    }

    public static void main(String[] args) {

        System.out.println(new DecodeWays().numDecodings("0"));
    }
}
