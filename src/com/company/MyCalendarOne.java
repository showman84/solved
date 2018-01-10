package com.company;

import java.util.TreeMap;

import java.util.TreeMap;

class MyCalendarOne {
    TreeMap<Integer, Integer> delta;

    public MyCalendarOne() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }

        if (ans <= 0) {
            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        int A[] =  {3,4,-1,1};

        MyCalendarOne calendarThree = new MyCalendarOne();

        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(15, 25));
        System.out.println(calendarThree.book(20, 30));
        System.out.println(calendarThree.book(5, 15));
        System.out.println(calendarThree.book(5, 10));
        System.out.println(calendarThree.book(25, 55));

    }

}
