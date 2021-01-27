package site.bulibucai.leetcode;

/**
 * 题目链接：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class P206 {
    /**
     * 分析：
     * 1.注意链表的断裂问题。
     * 2.注意不同指针的作用。
     * 3.时间复杂度：O(n)。
     * 4.空间复杂度：O(1)。
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; //prev 指针用于确定已经整理好的链表边界。
        ListNode curr = head; //curr 指针用于指定当前要反转的结点，起到遍历链表的作用。

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 分析：
     * 1.递归思想
     * 2.时间复杂度：O(n)。
     * 3.空间复杂度：O(n)。
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
