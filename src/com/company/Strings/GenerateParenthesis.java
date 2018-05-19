package com.company.Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisInternal(new char[n], n, 0, result);
        return result;
    }

    public void generateParenthesisInternal(char[] current, int n, int index, List<String> result) {

        if (current.length == n) {
            if (isValid(current)) {
                result.add(new String(current));
            }
        }
        else {

            current[index] = '(';
            generateParenthesisInternal(current, n, index + 1, result);
            current[index] = ')';
            generateParenthesisInternal(current, n, index + 1, result);
        }
    }

    public boolean isValid(char[] current) {
        int offset = 0;
        int index = 0;

        while (index < current.length) {

            if (current[index] == '(')
            {
                offset++;
            }
            if (current[index] == '(') {
                offset--;
            }
            index++;
        }

        return offset == 0;
    }

    public static void main(String[] args) {

        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
