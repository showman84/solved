package com.company;

import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }

    public static void main(String[] args) {

        int A[] =  {3,4,-1,1};

        MyCalendarThree calendarThree = new MyCalendarThree();

        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(50, 60));
        System.out.println(calendarThree.book(10, 40));
        System.out.println(calendarThree.book(5, 15));
        System.out.println(calendarThree.book(5, 10));
        System.out.println(calendarThree.book(25, 55));

    }

}