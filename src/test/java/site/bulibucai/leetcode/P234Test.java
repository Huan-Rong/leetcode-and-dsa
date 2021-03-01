package site.bulibucai.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class P234Test {

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(true, null),//链空
                Arguments.arguments(true, new P234.ListNode(1, null)),//只有一个结点
                Arguments.arguments(false, new P234.ListNode(1, new P234.ListNode(2, null))),//两个结点，但非回文
                Arguments.arguments(true, new P234.ListNode(2, new P234.ListNode(2, null))),//两个结点，且回文
                Arguments.arguments(false, new P234.ListNode(1, new P234.ListNode(2, new P234.ListNode(3, null)))),
                Arguments.arguments(true, new P234.ListNode(1, new P234.ListNode(2, new P234.ListNode(1, null)))),
                Arguments.arguments(true, new P234.ListNode(1, new P234.ListNode(2, new P234.ListNode(2, new P234.ListNode(1, null))))),
                Arguments.arguments(false, new P234.ListNode(1, new P234.ListNode(2, new P234.ListNode(2, new P234.ListNode(1, new P234.ListNode(4, null))))))
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void isPalindrome(boolean expected, P234.ListNode head) {
        Assertions.assertEquals(expected, P234.isPalindrome(head));
    }
}