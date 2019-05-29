package com.company.Numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwoSum {


    public int[] twoSum (int[] num, int target) {

        int result[] = new int[2];
        HashMap indexMap = new HashMap();
        for (int index = 0; index < num.length; index ++) {
            if (indexMap.containsKey(target-num[index])) {
                result[0] = (int)indexMap.get(target-num[index]);
                result[1] = index;
                break;
            }
            else {
                indexMap.put(num[index], index);
            }
        }
        return result;
    }

  public static void main(String[] args) {
        int numbers [] = new int[]{2, 7 , 11, 15};
        System.out.println(new TwoSum().twoSum(numbers, 9));
    }
}
