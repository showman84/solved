package com.company;



public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int i = 1;
        ListNode start = dummy;
        while (head != null) {

            if (i%k == 0){
                start = reverse(start, head.next);
                head = start.next;
            }
            else {
                head = head.next;
            }
            i++;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode begin, ListNode end) {

        ListNode current, previous, next;
        current = begin.next;
        previous = begin;

        ListNode first = begin.next;

        while (current != end) {
            ListNode temp = current.next;
            current.next = previous;

            previous = current;
            current = temp;
        }

        begin.next = previous;
        first.next = current;

        return first;
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
