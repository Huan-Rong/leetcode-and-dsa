package site.bulibucai;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P26Test {

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(5,
                        new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}),
                Arguments.arguments(5,
                        new int[]{1, 2, 3, 4, 5})
//                Arguments.arguments(0, null)
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void removeDuplicates(int expected, int[] nums) {
        assertEquals(expected, P26.removeDuplicates(nums));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void removeDuplicates2(int expected, int[] nums) {
        assertEquals(expected, P26.removeDuplicates2(nums));
    }
}