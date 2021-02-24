package site.bulibucai.dsa.linkedlist;

import java.util.ArrayList;

/**
 * 使用单链表实现 LRU 算法：
 * <p>
 *     1.有序单链表：越接近链表尾部的节点，是越久之前访问的；
 *     2.当查找一个新节点时：
 *     2.1如果链表中存在该节点，那么将该节点从原有位置中删除，并将之插到链头；
 *     2.2如果链表中不存在该节点且没有超过链表的 capacity，那么直接将该节点插入到链头；
 *     2.3如果链表中不存在该节点且链表已达到 capacity 限制，那么将链尾节点删除，并将新节点插到链头；
 *     2.4注意，无论链表中存不存在该节点，该节点都将会插入到链头；
 * </p>
 *
 *单链表的编程技巧：
 * <p>
 *     1.链表的插入、删除操作都需要知道前驱节点的指针；
 *     2.删除节点时要注意 GC 友好处理；
 *     3.使用带头链表简化代码实现；
 *
 * </p>
 */
public class LruUsingSingleLinkedList {

    //带头链表的实现方式
    private final Node head = new Node(null, null);
    //默认链表长度
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private int count;

    /**
     * 时间复杂度分析：
     * <p>
     *     1.将该方法的代码分为四个部分进行分析：
     *     1.1第一部分，while 循环，时间复杂度为 O(n)；
     *     1.2第二部分，删除当前结点，时间复杂度为 O(1)；
     *     1.3第三部分，删除尾结点，时间复杂度为 O(n)；
     *     1.4第四部分，插入头节点，最好时间复杂度为 O(1)，最坏时间复杂度为 O(n);
     *     1.5根据加法原则，该方法的时间复杂度为 O(n)；
     * </p>
     */
    public void access(String data) {
        //边界条件处理
        if(data == null) {
            return;
        }

        Node prev = head;
        Node curr = head.getNext();
        while(curr != null && curr.getData() != data) {
            prev = curr;
            curr = curr.getNext();
        }

        if (curr != null) {
            //分支处理：找到节点的情况的额外处理，即将该节点从当前位置删除；
            prev.setNext(curr.getNext());
        } else if (count >= capacity) {
            //分支处理：没找到节点，且已经到达 capacity 限制的情况的额外处理，即删除尾结点；
            removeLast();
        }
        //没找到节点，但没有到达 capacity 限制的情况不需要进行额外处理；
        //三种情况最终都要将节点插入到链头；
        insertFirst(data);
    }

    /**
     * 插入一个新节点到链头。
     *
     * 时间复杂度分析：
     * <p>
     *     1.正常情况下，该方法的时间复杂度都为 O(1)；
     *     2.当 count >= capacity 的情况下，每次访问链表都必须执行 removeLast() 操作，所以每次的时间复杂度都会退化为 O(n)；
     *     这是一个可以想办法优化的地方，比如扩容，由于链表扩容不存在数据迁移操作，因此时间复杂度为 O(1)；
     * </p>
     */
    private boolean insertFirst(String data) {
        //capacity限制处理
        if (count >= capacity) {
            removeLast();
        }
        //插入新节点
        Node first = new Node(data, head.getNext());
        head.setNext(first);
        count++;
        return true;
    }

    /**
     * 删除单链表的尾节点。
     *
     * 时间复杂度分析：与链表的长度成正比，即 O(n)；
     */
    private void removeLast() {
        //边界处理
        if (head.getNext() == null) {
            return;
        }

        Node prev = head;
        Node curr = head.getNext();
        while (curr != null && curr.getNext() != null) {
            Node tmp = curr.getNext();
            prev = curr;
            curr = tmp;
        }

        prev.setNext(null);
        this.count--;
    }

    /**
     * 将链表按照顺序转换为数组返回。方便测试。
     */
    public String[] toStringArray() {
        //边界处理
        if (count == 0) {
            return null;
        }

        ArrayList<String> ret = new ArrayList<>();
        Node curr = head.getNext();
        while(curr != null) {
            ret.add(curr.getData());
            curr = curr.getNext();
        }
        String[] rets = new String[ret.size()];
        return ret.toArray(rets);
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
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
