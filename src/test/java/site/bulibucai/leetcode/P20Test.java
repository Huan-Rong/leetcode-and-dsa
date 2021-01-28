package site.bulibucai.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class P20Test {

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.arguments(true, ""),
                Arguments.arguments(true, "{[]}"),
                Arguments.arguments(true, "{}"),
                Arguments.arguments(true, "()[]{{[]}}"),
                Arguments.arguments(false, "{[}}")
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void isValid(boolean flag, String s) {
        Assertions.assertEquals(flag, P20.isValid(s));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void isValid2(boolean flag, String s) {
        Assertions.assertEquals(flag, P20.isValid2(s));
    }
}