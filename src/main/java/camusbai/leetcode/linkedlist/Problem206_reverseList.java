package camusbai.leetcode.linkedlist;

public class Problem206_reverseList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode head = new Problem206_reverseList().reverseList(n1);
        System.out.println(head.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevPtr = null;
        ListNode currPtr = head;
        ListNode nextPtr = head.next;

        while (nextPtr != null) {
            currPtr.next = prevPtr;
            prevPtr = currPtr;
            currPtr = nextPtr;
            nextPtr = nextPtr.next;
        }

        currPtr.next = prevPtr;
        return currPtr;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
