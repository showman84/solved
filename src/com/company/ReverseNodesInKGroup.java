package com.company;



public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        int sIndex = 1;
        ListNode result = head;
        ListNode lastRerverse = head;
        ListNode prev = null;
        while (head != null) {
            if (sIndex % k == 0) {
                int operations = 0;
                while(operations <= k/2) {
                    ListNode temp = prev;
                    prev.next = head.next;
                    head.next = lastRerverse;
                    operations++;
                }
            }
            prev = head;
            head = head.next;

            sIndex++;
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println(new ReverseNodesInKGroup().reverseKGroup(node, 3));
    }
}
