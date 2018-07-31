package camusbai.leetcode.linkedlist;

import java.util.Stack;

public class Problem445_add_number {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode l1 = node;
        for (int i = 0; i < 9; i++) {
            ListNode n = new ListNode(9);
            node.next = n;
            node = n;
        }

        ListNode l2 = new ListNode(7);

        new Problem445_add_number().addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        boolean carry = false;
        ListNode result = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int digit1 = s1.isEmpty() ? 0 : s1.pop().val;
            int digit2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum =  digit1+ digit2;
            sum = sum + (carry ? 1 : 0);
            if (sum > 9) {
                sum %= 10;
                carry = true;
            } else {
                carry = false;
            }
            ListNode n = new ListNode(sum);
            n.next = result;
            result = n;
        }

        if (carry) {
            ListNode n = new ListNode(1);
            n.next = result;
            result = n;
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
