package site.bulibucai.leetcode;

/**
 * 题目链接：https://leetcode-cn.com/problems/design-circular-queue/
 */
public class P622 {
    private int[] arr;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public P622(int k) {
        //注意题目中说队列长度为 k，按照当前的解法会浪费 1 个空间，因此需要使用 k + 1个空间。
        this.capacity = k + 1;
        arr = new int[this.capacity];
    }

    /**
     * 入队操作
     */
    public boolean enQueue(int value) {
        //队满处理
        if (isFull()) {
            return false;
        }

        arr[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 出队操作
     */
    public boolean deQueue() {
        //队空处理
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /**
     * 获取第一个元素
     */
    public int Front() {
        //队空处理
        if (isEmpty()) {
            return -1;
        }

        return arr[head];
    }

    /**
     * 获取最后一个元素
     */
    public int Rear() {
        //队空处理
        if (isEmpty()) {
            return -1;
        }

        //获取最后一个元素
        return arr[(tail - 1 + capacity) % capacity];
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
