package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval {
  int start;
  int end;
    Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }


public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> timeline = new ArrayList();
        schedule.forEach(interval -> timeline.addAll(interval));
        Collections.sort(timeline, ((a, b) -> a.start - b.start));

        List<Interval> result = new ArrayList<>();

        if (timeline.isEmpty()) {
            return result;
        }

        Interval first = timeline.get(0);
        for( Interval interval: timeline) {
            if (interval.start > first.end) {
                result.add(new Interval(first.end, interval.start));
                first = interval;
            }
            else {
                first = first.end < interval.end ? interval: first;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList intervals = new ArrayList();

        ArrayList firstEmployee = new ArrayList();

        firstEmployee.add(new Interval(1, 2));
        firstEmployee.add(new Interval(5, 6));


        ArrayList secondEmployee = new ArrayList();

        firstEmployee.add(new Interval(1, 3));
        firstEmployee.add(new Interval(4, 10));

        intervals.add(firstEmployee);
        intervals.add(secondEmployee);

        System.out.println(new EmployeeFreeTime().employeeFreeTime(intervals));
    }
}
