package site.bulibucai.leetcode;

/**
 * 题目链接: https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class P234 {

    public static boolean isPalindrome(ListNode head) {
        //边界处理
        if (head == null) {
            return true;
        }

        //第一步，遍历获取中间结点
        ListNode midNode = getHalfNode(head);
        //第二步，反转后半部分链表
        ListNode newHead = reverseList(midNode.next);
        //第三步，比较判断是否为回文链表
        boolean isPalindrome = true;
        ListNode p1 = head;
        ListNode p2 = newHead;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //第四步，再次反转，恢复链表原样
        midNode.next = reverseList(newHead);

        return isPalindrome;
    }

    /**
     * 反转链表，并返回新的头结点。
     *
     * 注意，环的处理。
     */
    private static ListNode reverseList(ListNode node) {
        ListNode previous = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }

    /**
     * 获取中间结点：中间结点之后的结点需要进行反转操作。
     */
    private static ListNode getHalfNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}