package site.bulibucai.dsa.queue;

/**
 * 基于链表实现的队列。
 * <p>
 * 由于是使用了链表来实现，因此没有队满的限制。
 */
public class BasicLinkedQueue {

    private final Node head;
    private Node tail;

    /**
     * 使用带头链表
     */
    public BasicLinkedQueue() {
        head = new Node();
        tail = head;
    }

    /**
     * 入队操作
     */
    public boolean enqueue(String data) {
        Node next = new Node(data, null);
        tail.setNext(next);
        tail = next;
        return true;
    }

    /**
     * 出队操作
     */
    public String dequeue() {
        Node tmp = head.getNext();
        //队空处理
        if (tmp == null) {
            return null;
        }
        head.setNext(tmp.getNext());
        return tmp.getData();
    }

    /**
     * 使用 private 级别的内部类的原因是，结点是该实现中数据结构的一部分，不应当对外部开放，外部关心的重点是数据。
     */
    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

