package site.bulibucai.leetcode;

/**
 * 题目链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class P21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * 基于递归的解法2。
     * 时间复杂度：O(n+m)。
     * 空间复杂度：O(n+m)。
     */
    public static ListNode rec(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = rec(l1.next, l2);
            return l1;
        } else {
            l2.next = rec(l1, l2.next);
            return l2;
        }
    }

    /**
     * 基于递归的解法1。
     * 时间复杂度分析：O(n+m)。
     * 空间复杂度分析：O(n+m)。
     */
    public static ListNode recursion(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        recursion(l1, l2, curr);
        return head.next;
    }

    private static void recursion(ListNode l1, ListNode l2, ListNode curr) {
        if (l1 == null) {
            curr.next = l2;
            return;
        }
        if (l2 == null) {
            curr.next = l1;
            return;
        }

        if (l1.val <= l2.val) {
            curr.next = l1;
            recursion(l1.next, l2, curr.next);
        } else {
            curr.next = l2;
            recursion(l1, l2.next, curr.next);
        }
    }

    /**
     * 迭代法。
     * 1.带头链表的实现，可以简化代码。
     * 2.时间复杂度分析：每一次 while 循环只能处理一个元素，两个列表的元素加起来是 n+m，因此时间复杂度是 O(n+m)。
     * 3.空间复杂度分析：O(1)。
     */
    public static ListNode withDummy(ListNode l1, ListNode l2) {
        // 设计带头链表
        ListNode head = new ListNode();
        ListNode curr = head;
        // while 循环能够覆盖边界条件，因此边界条件不需要单独处理。
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 处理剩余的元素，下面的代码是对两个 if 语句的优化。
        curr.next = l1 != null ? l1 : l2;

        return head.next;
    }

    /**
     * 迭代法：不带头的实现。
     */
    private static ListNode noDummy(ListNode l1, ListNode l2) {
        // 边界条件处理
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode curr = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (head == null) {
                    head = l1;
                    curr = l1;
                } else {
                    curr.next = l1;
                    curr = curr.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    curr = l2;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return head;
    }
}

