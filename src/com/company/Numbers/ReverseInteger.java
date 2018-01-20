package com.company.Numbers;

import com.company.Arrays.RotateArray;

public class ReverseInteger {
    public int reverse(int x) {

        long result = 0;

        boolean isNegative = false;

        if (x < 0) {

            isNegative = true;
            x= x * -1;
        }

        while ( x > 0) {

            int reminder = x % 10;
            if ((result * 10 + reminder >= Integer.MAX_VALUE)) {
                result = 0;
                break;
            }
            result = result * 10 + reminder;
            x = x / 10;
        }

        return isNegative ? (int)result * -1 : (int)result;

    }

    public static void main(String[] args) {

       System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
