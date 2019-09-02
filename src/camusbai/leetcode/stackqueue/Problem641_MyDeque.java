package camusbai.leetcode.stackqueue;

public class Problem641_MyDeque {
    public static void main(String[] args) {
        Problem641_MyDeque deque = new Problem641_MyDeque(3);

        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertFront(4);
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        deque.deleteLast();
        deque.insertFront(4);
        System.out.println(deque.getFront());
    }


    private final int capacity;
    private int size = 0;
    private DequeNode head = null;
    private DequeNode tail = null;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public Problem641_MyDeque(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size > capacity - 1) {
            return false;
        }

        DequeNode newHead = new DequeNode(value);
        newHead.prev = null;

        if (head == null && tail == null) {
            newHead.next = null;
            head = newHead;
            tail = newHead;
        } else if (head != null && tail != null) {
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        } else {
            System.out.println("Error, Shouldn't happen");
            return false;
        }

        size++;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size > capacity - 1) {
            return false;
        }

        DequeNode newTail = new DequeNode(value);
        newTail.next = null;

        if (head == null && tail == null) {
            newTail.prev = null;
            tail = newTail;
            head = newTail;
        } else if (head != null && tail != null) {
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        } else {
            System.out.println("Error, Shouldn't happen");
            return false;
        }

        size++;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size < 1) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        head = head.next;
        head.prev.next = null;
        head.prev = null;
        size--;

        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size < 1) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        size--;

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size < 1) {
            return -1;
        }

        return head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size < 1) {
            return -1;
        }

        return tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }


    static class DequeNode {
        DequeNode prev;
        DequeNode next;

        int val;

        DequeNode(int val) {
            this.val = val;
        }
    }
}
