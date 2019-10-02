package camusbai.leetcode.linkedlist;

import camusbai.leetcode.global.ListNode;

/**
 * Created by camusbai on 3/8/16.
 */
public class Problem237_DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next = null;
    }
}
