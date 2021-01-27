package site.bulibucai.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import site.bulibucai.StringsToIntsConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P283Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/p283.csv")
    void moveZeroes(@ConvertWith(StringsToIntsConverter.class) int[] expected,
                    @ConvertWith(StringsToIntsConverter.class) int[] nums) {
        assertArrayEquals(expected, P283.moveZeroes(nums));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/p283.csv")
    void moveZeroes1(@ConvertWith(StringsToIntsConverter.class) int[] expected,
                     @ConvertWith(StringsToIntsConverter.class) int[] nums) {
        assertArrayEquals(expected, P283.moveZeroes1(nums));
    }

}