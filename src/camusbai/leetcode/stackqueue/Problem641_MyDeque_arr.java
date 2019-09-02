package camusbai.leetcode.stackqueue;

public class Problem641_MyDeque_arr {
    public static void main(String[] args) {
        Problem641_MyDeque_arr deque = new Problem641_MyDeque_arr(3);

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

    private final int[] dat;
    private final int capacity;
    private int size;
    private int head, tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public Problem641_MyDeque_arr(int k) {
        capacity = k;
        dat = new int[k];
        size = 0;
    }

    private int moveIdxRight(int idx) {
        return (idx + 1) & capacity;
    }

    private int moveIdxLeft(int idx) {
        return capacity - (capacity + 1 - idx) % capacity;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size < capacity) {
            if (size == 0) {
                int idx = capacity / 2;
                head = idx;
                tail = idx;
            } else {
                head = moveIdxLeft(head);
            }

            dat[head] = value;
            size++;

            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size < capacity) {
            if (size == 0) {
                int idx = capacity / 2;
                tail = idx;
                head = idx;
            } else {
                tail = moveIdxRight(tail);
            }

            dat[tail] = value;
            size++;

            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size > 0) {
            head = moveIdxRight(head);
            size--;

            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size > 0) {
            tail = moveIdxLeft(tail);
            size--;

            return true;
        } else {
            return false;
        }

    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size > 0) {
            return dat[head];
        } else {
            return -1;
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size > 0) {
            return dat[tail];
        } else {
            return -1;
        }

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
}
