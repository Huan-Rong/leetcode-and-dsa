package site.bulibucai;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class P70Test {

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",
            "3,3",
            "5,4",
            "8,5",
            "13,6",
            "21,7",
            "34,8"
    })
    void climbStairs(int expected, int n) {
        assertEquals(expected, P70.climbStairs(n));
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",
            "3,3",
            "5,4",
            "8,5",
            "13,6",
            "21,7",
            "34,8"
    })
    void climbStairs1(int expected, int n) {
        assertEquals(expected, P70.climbStairs1(n));
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",
            "3,3",
            "5,4",
            "8,5",
            "13,6",
            "21,7",
            "34,8"
    })
    void climbStairs2(int expected, int n) {
        assertEquals(expected, P70.climbStairs2(n));
    }
}