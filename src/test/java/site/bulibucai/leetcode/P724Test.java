package site.bulibucai.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class P724Test {

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(3, new int[]{1, 7, 3, 6, 5, 6}),
                Arguments.arguments(-1, new int[]{1, 2, 3}),
                Arguments.arguments(0, new int[]{2, 1, -1}),
                Arguments.arguments(4, new int[]{0, 0, 0, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void pivotIndex(int index, int[] nums) {
        Assertions.assertEquals(index, P724.pivotIndex(nums));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void pivotIndex2(int index, int[] nums) {
        Assertions.assertEquals(index, P724.pivotIndex2(nums));
    }
}