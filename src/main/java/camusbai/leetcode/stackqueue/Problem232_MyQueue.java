package camusbai.leetcode.stackqueue;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class Problem232_MyQueue {
  public static void main(String[] args) {
    Problem232_MyQueue queue = new Problem232_MyQueue();
    queue.push(1);
    queue.push(2);
    queue.push(3);

    queue.pop();
    System.out.println(queue.peek());
  }

  Stack<Integer> inStack = new Stack<Integer>();
  Stack<Integer> outStack = new Stack<Integer>();
  private int peek;
  // Push element x to the back of queue.
  public void push(int x) {
    if(empty())
      peek = x;

    while (!outStack.empty())
      inStack.push(outStack.pop());
    inStack.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    while(!inStack.empty())
      outStack.push(inStack.pop());
    outStack.pop();

    if(!outStack.empty())
      peek = outStack.peek();
  }

  // Get the front element.
  public int peek() {
    return peek;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return inStack.isEmpty()&&outStack.isEmpty();
  }
}
