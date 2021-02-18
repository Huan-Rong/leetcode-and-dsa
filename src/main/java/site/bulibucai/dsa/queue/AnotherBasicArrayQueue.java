package site.bulibucai.dsa.queue;

/**
 * 对于 BasicArrayQueue 的改进。
 */
public class AnotherBasicArrayQueue {

    private final String[] arr;
    private final int capacity;

    private int head;
    private int tail;

    public AnotherBasicArrayQueue(int capacity) {
        arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队操作
     *
     * 1.最好时间复杂度分析：当 tail != capacity 时，为最好时间复杂度，即 O(1)。
     * 2.最坏时间复杂度分析：当 tail != capacity && head != 0 时，为最坏时间复杂度，即 O(n)。
     * 3.平均时间复杂度分析：当 tail 取 [0, n-1] 时，时间复杂度为 O(1)；当 tail == n 时，时间复杂度为 O(n)；使用摊还分析，即 O(1)。
     */
    public boolean enqueue(String ele) {
        //队满处理
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }
            //数据迁移，基操熟
            for (int i = head; i < tail; i++) {
                arr[i - head] = arr[i];
            }
            tail -= head;
            head = 0;
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
