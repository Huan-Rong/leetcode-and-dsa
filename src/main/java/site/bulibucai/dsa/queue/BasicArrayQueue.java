package site.bulibucai.dsa.queue;

/**
 * 基于数组实现的基本队列。
 *
 * 这种实现的一个问题是，随着不断的入队出队操作，head 和 tail 指针会不断地向右移动，导致即使队列中有空闲空间也无法被使用。
 */
public class BasicArrayQueue {

    private String[] arr;
    //capacity 表示数组的大小
    private int capacity;

    //head 指针，指向下一个可以出队的元素
    private int head;
    //tail 指针，指向下一个可以入队的位置
    private int tail;

    /**
     * 在该实现中，队列的容量是固定不变的
     */
    public BasicArrayQueue(int capacity) {
        arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队操作
     */
    public boolean enqueue(String ele) {
        //队满处理
        if (tail == capacity) {
            return false;
        }
        arr[tail++] = ele;
        return true;
    }

    /**
     * 出队操作
     */
    public String dequeue() {
        //队空处理
        if (head == tail) {
            return null;
        }
        return arr[head++];
    }
}
