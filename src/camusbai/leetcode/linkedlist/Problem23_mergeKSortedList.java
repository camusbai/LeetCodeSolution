package camusbai.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23_mergeKSortedList {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        new Problem23_mergeKSortedList().mergeKLists(new ListNode[]{h1, h2, h3});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }

        ListNode head = minHeap.poll();

        ListNode visitor = head;
        while (!minHeap.isEmpty()) {
            if (visitor.next != null) {
                while (visitor.next != null && visitor.next.val <= minHeap.peek().val) {
                    visitor = visitor.next;
                }

                if (visitor.next != null) {
                    minHeap.offer(visitor.next);
                }
            }

            ListNode n = minHeap.poll();
            visitor.next = n;
            visitor = n;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
