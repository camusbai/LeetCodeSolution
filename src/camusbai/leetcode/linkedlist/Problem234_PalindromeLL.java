package camusbai.leetcode.linkedlist;

import camusbai.leetcode.global.ListNode;
import camusbai.leetcode.global.Solution;
import camusbai.leetcode.util.Utils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Problem234_PalindromeLL {
  public static void main(String[] args) {
    String serial = "12344";
    ListNode head=null, next=null;
    for(int i=0;i<serial.length();++i) {
      if (i == 0) {
        head = new ListNode(Integer.parseInt(serial.substring(i, i + 1)));
        next = head;
      } else {
        ListNode temp = new ListNode(Integer.parseInt(serial.substring(i, i + 1)));
        next.next = temp;
        next = temp;
      }
    }
    System.out.println(Utils.reverseLinkedList(head));
    System.out.println(isPalindrome(head));
  }

  public static boolean isPalindrome(ListNode head) {
    Solution sol = Solution.NAIVE;
    switch (sol) {
      case NAIVE:
        if(head==null)
          return true;

        ListNode next = head;
        ListNode rvse = new ListNode(next.val);
        rvse.next = null;
        while (next.next != null) {
          next = next.next;
          ListNode temp = new ListNode(next.val);
          temp.next = rvse;
          rvse = temp;
        }

        next = head;
        while (next.next != null) {
          if(next.val!=rvse.val)
            return false;
          next = next.next;
          rvse = rvse.next;
        }
        return true;
      default:
        return false;
    }
  }
}