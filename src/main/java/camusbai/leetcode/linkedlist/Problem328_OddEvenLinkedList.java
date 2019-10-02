package camusbai.leetcode.linkedlist;

import camusbai.leetcode.global.ListNode;

/**
 * Created by camusbai on 2/20/2016.
 */
public class Problem328_OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode odd = head, even = head.next;
    ListNode copyOfFirstEven = even;
    while (even.next != null && even.next.next != null) {
      ListNode nextOdd = null, nextEven = null;
      nextOdd = even.next;
      nextEven = even.next.next;
      odd.next = nextOdd; even.next = nextEven;
      odd = nextOdd; even = nextEven;
    }

    if (even.next != null) {
      odd.next = even.next;
      odd = odd.next;
    }

    odd.next = copyOfFirstEven;
    even.next = null;

    return head;
  }
}
