package com.company.Arrays;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        Hashtable<Integer, List<Integer>> freqMap = new Hashtable<>();
        Hashtable<Integer, Integer> freqMap2 = new Hashtable<>();


        for (int i = 0; i < nums.length; i++) {

            if (freqMap2.containsKey(nums[i])) {
                int freq = freqMap2.get(nums[i]);
                freqMap2.put(nums[i], freq + 1);
            }
            else {
                freqMap2.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedList = sortByComparator(freqMap2);

        for (int i = 0; i < k; i++) {

           result.add(sortedList.get(i).getKey());
        }

        return result;

    }

    private static List<Map.Entry<Integer, Integer>> sortByComparator(Map<Integer, Integer> unsortMap) {

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                //if (order) {
                    return o2.getValue().compareTo(o1.getValue());

            }
        });


        return list;

    }


    public static void main(String[] args) {
        int numbers [] = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new TopKFrequentElements().topKFrequent(numbers, 2));
    }
}
