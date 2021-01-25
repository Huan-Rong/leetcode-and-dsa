package site.bulibucai;

/**
 * 题目链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 解题要点：
 * 1.要求原地操作。
 * 2.不需要考虑数组中超出新长度的元素。
 * 3.数组是有序的。
 */
public class P26 {

    /**
     * 分析：
     * 1.左右指针法，需要注意哪个指针负责遍历数组，哪个指针逻辑分割数组；
     * 该题的解法与 P283 类似。
     * 2.时间复杂度：O(n)。
     * 3.空间复杂度：O(1)。
     * 4.代码的实现细节不够优雅。
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            nums[++j] = nums[i];
        }
        //j表示索引，但题目要求返回的是处理后数组的元素个数。
        return j + 1;
    }

    /**
     * 分析：
     * 1.优化 i = 0、j = 0 的情况，这种情况是可以直接跳过的。
     * 2.优化数组为 [1,2,3,4,5] 的情况，避免当前元素 nums[i] 给自己赋值。
     * 3.优化边界情况的处理。
     */
    public static int removeDuplicates2(int[] nums) {
        //处理边界
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int i = 1;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                //表达式 j + 1 != i，是为了避免处理类似于 [1,2,3,4,5] 的数组。
                if (j + 1 == i) {
                    j++;
                    continue;
                }
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
