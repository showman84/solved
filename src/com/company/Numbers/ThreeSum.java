package com.company.Numbers;

import com.company.Arrays.RotateArray;

import java.util.*;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i ++) {

            if (i == 0 || (i > 0 && num[i] != num[i-1])) {

                int front = i + 1, back = num.length - 1;

                int target = -num[i];

                while (front < back) {

                    if (num[front] + num[back] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(num[front]);
                        list.add(num[back]);
                        list.add(-target);

                        result.add(list);

                        while (front < back && num[front] == num[front + 1]) {
                            front++;
                        }
                        while (front < back && num[back] == num[back - 1]) {
                            back--;
                        }

                        front++;
                        back--;

                    } else if (num[front] + num[back] < target) {
                        front++;
                    } else {
                        back--;
                    }
                }
            }
        }

        return result;
    }

  public static void main(String[] args) {
       // int numbers [] = new int[]{-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
       int numbers [] = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(numbers));
    }
}
