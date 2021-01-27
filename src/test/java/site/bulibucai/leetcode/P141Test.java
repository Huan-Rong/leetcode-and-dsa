package site.bulibucai.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P141Test {

    static Stream<Arguments> getArguments() {
        //第一组数据
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        //第二组数据
        ListNode nn1 = new ListNode(1);
        ListNode nn2 = new ListNode(2);
        ListNode nn3 = new ListNode(3);
        ListNode nn4 = new ListNode(4);
        ListNode nn5 = new ListNode(5);

        nn1.next = nn2;
        nn2.next = nn3;
        nn3.next = nn4;
        nn4.next = nn5;
        nn5.next = null;
        return Stream.of(
                Arguments.arguments(
                        true,
                        n1
                ),
                Arguments.arguments(
                        false,
                        nn1
                )

        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void hasCycle(boolean flag, ListNode head) {
        assertEquals(flag, P141.hasCycle(head));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void hasCycle2(boolean flag, ListNode head) {
        assertEquals(flag, P141.hasCycle2(head));
    }
}