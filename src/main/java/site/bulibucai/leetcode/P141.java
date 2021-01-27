package site.bulibucai.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接：https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 解题要点：
 * 1.有环的定义为，尾结点指向链表中其他的任一个结点。
 * 2.pos 表示从 0 开始的索引，但并非入参，只是作为题目说明。
 * 3.最好能够原地操作。
 */
public class P141 {

    /**
     * 分析：
     * 1.使用快慢指针。
     * 2.空间复杂度：O(1)。
     * 3.时间复杂度：O(n)。时间复杂度的分析见：https://leetcode-cn.com/problems/linked-list-cycle-ii/。
     */
    public static boolean hasCycle(ListNode head) {
        //特殊情况判定
        if (head == null || head.next == null) {
            return false;
        }

        //设置快慢指针
        ListNode i = head;
        ListNode j = head.next;
        while (i != j) {
            //如果不是环形链表，那么快指针必定会走到链表尾部。
            if (j == null || j.next == null) {
                return false;
            }
            //快慢指针的步长不同。
            i = i.next;
            j = j.next.next;
        }
        //当快慢两个指针指向同一个结点时，则该链表为环形链表。
        return true;
    }

    /**
     * 分析：
     * 1.使用哈希表。
     * 2.空间复杂度：O(n)。
     * 3.时间复杂度：O(n)。
     */
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        while (head != null) {
            if (!cache.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
