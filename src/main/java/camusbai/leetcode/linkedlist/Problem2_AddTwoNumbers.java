package camusbai.leetcode.linkedlist;

import camusbai.leetcode.global.ListNode;

/**
 * Created by camusbai on 3/17/16.
 */
public class Problem2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, lastNode = result;
        int carryOver = 0;
        ListNode r1 = l1, r2 = l2;
        while (r1 != null || r2 != null || carryOver != 0) {
            int l1Val = 0, l2Val = 0;
            if (r1 != null) {
                l1Val = r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                l2Val = r2.val;
                r2 = r2.next;
            }
            int sum = l1Val + l2Val + carryOver;
            if (carryOver == 1)
                carryOver--;

            if (sum > 9) {
                sum -= 10;
                carryOver++;
            }
            if (result == null) {
                result = new ListNode(sum);
                result.next = null;
                lastNode = result;
            } else {
                ListNode newNode = new ListNode(sum);
                newNode.next = null;
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);

        ListNode ll1 = new ListNode(5);
        ListNode ll2 = new ListNode(5);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}