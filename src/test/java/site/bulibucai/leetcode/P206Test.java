package site.bulibucai.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P206Test {

    static Stream<Arguments> getArguments() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        return Stream.of(
                Arguments.arguments(n1)
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void reverseList(ListNode head) {
        ListNode newHead = P206.reverseList(head);
        assertEquals(5, newHead.val);
        assertEquals(4, newHead.next.val);
        assertEquals(3, newHead.next.next.val);
        assertEquals(2, newHead.next.next.next.val);
        assertEquals(1, newHead.next.next.next.next.val);
        assertEquals(null, newHead.next.next.next.next.next);
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void reverseList2(ListNode head) {
        ListNode newHead = P206.reverseList2(head);
        assertEquals(5, newHead.val);
        assertEquals(4, newHead.next.val);
        assertEquals(3, newHead.next.next.val);
        assertEquals(2, newHead.next.next.next.val);
        assertEquals(1, newHead.next.next.next.next.val);
        assertEquals(null, newHead.next.next.next.next.next);
    }
}