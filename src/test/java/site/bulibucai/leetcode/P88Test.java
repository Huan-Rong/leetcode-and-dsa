package site.bulibucai.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P88Test {

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(
                        new int[]{1, 2, 3, 4, 7},
                        new int[]{4, 7, 0, 0, 0},
                        2,
                        new int[]{1, 2, 3},
                        3
                ),
//              下面这组测试数据不可用。因为题目明确说明了 nums1.length = m + n。
//              另外，这组测试数据对于第一种"先合并后排序"的解法不适用。
//                Arguments.arguments(
//                        new int[]{1, 2, 3, 4, 7, 0, 0, 0, 0, 0},
//                        new int[]{4, 7, 0, 0, 0, 0, 0, 0, 0, 0},
//                        2,
//                        new int[]{1, 2, 3},
//                        3
//                ),
                Arguments.arguments(
                        new int[]{1, 2, 3, 3, 3, 4, 6},
                        new int[]{1, 2, 3, 4, 0, 0, 0},
                        4,
                        new int[]{3, 3, 6},
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void merge(int[] expected, int[] nums1, int m, int[] nums2, int n) {
        assertArrayEquals(expected, P88.merge(nums1, m, nums2, n));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void merge2(int[] expected, int[] nums1, int m, int[] nums2, int n) {
        assertArrayEquals(expected, P88.merge2(nums1, m, nums2, n));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void merge3(int[] expected, int[] nums1, int m, int[] nums2, int n) {
        assertArrayEquals(expected, P88.merge3(nums1, m, nums2, n));
    }
}