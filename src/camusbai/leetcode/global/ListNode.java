package camusbai.leetcode.global;

/**
 * Created by camusbai on 2/15/2016.
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.val + "->");
    ListNode next = this.next;
    while (next != null) {
      builder.append(next.val + "->");
      next = next.next;
    }

    return builder.substring(0, builder.length() - 2);
  }
}
