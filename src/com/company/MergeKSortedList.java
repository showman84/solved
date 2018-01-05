package com.company;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergeKSortedList {

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null, root = null;
        boolean nodeAdded = false;
        do {

            int value = findSmallestNode(lists);
            if (value == Integer.MIN_VALUE) {
                nodeAdded = false;
            }
            else {
                nodeAdded = true;
                if (result == null) {
                    result = new ListNode(value);
                    root = result;
                }
                else {
                    result.next = new ListNode(value);
                    result = result.next;
                }
            }
        }
        while (nodeAdded == true);
        return root;
    }

    public int findSmallestNode(ListNode[] lists) {
       int smallestNodeIndex = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (lists[smallestNodeIndex] == null || lists[i].val < lists[smallestNodeIndex].val) {
                smallestNodeIndex = i;
            }
        }
        if (lists[smallestNodeIndex] != null) {
            int value = lists[smallestNodeIndex].val;
            lists[smallestNodeIndex] = lists[smallestNodeIndex].next;
            return value;
        }
        return Integer.MIN_VALUE;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(2);
        lists[0] = node1;
        ListNode node = new ListNode(-1);
        lists[2] = node;
        System.out.println(new MergeKSortedList().mergeKLists(lists));
    }
}
