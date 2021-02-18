package site.bulibucai.dsa.queue;

/**
 * 循环队列的实现。
 */
public class CircularQueue {

    private final String[] arr;
    private final int capacity;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队操作。
     */
    public boolean enqueue(String ele) {
        //队满处理
        if ((tail + 1) % capacity != head) {
            return false;
        }
        arr[tail] = ele;
        //注意尾指针的处理
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 出队操作。
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String tmp = arr[head];
        //注意头指针的处理
        head = (head + 1) % capacity;
        return tmp;
    }
}
