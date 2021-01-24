package site.bulibucai;

/**
 * 题目链接：https://leetcode-cn.com/problems/move-zeroes/
 *
 * 解题要点：
 * 1.数组的双指针法，要注意哪个指针用于遍历数组，哪个指针用于逻辑分割数组。
 * 2.什么情况下两个指针的距离会变大。
 */
public class P283 {
    /**
     * 分析：
     * 1.原地操作，空间复杂度为 O(1)。
     * 2.时间复杂度为 O(n)。
     *
     *   但实际上，时间复杂度是由两个循环构成的。
     *   对于某种类型的测试数据，如 0,0,0,0,0,0,1，第2个循环的循环次数只比第1个循环的循环次数少一次。
     */
    public static int[] moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            //i==j 表明两个指针指向一个非零元素
            if (nums[i] == 0 || i == j) {
                continue;
            }
            //覆盖
            nums[j++] = nums[i];
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
        return nums.clone();
    }

    /**
     * 分析：
     * 1.原地操作，空间复杂度为 O(1)。
     * 2.时间复杂度为 O(n)，避免了第2个循环。
     */
    public static int[] moveZeroes1(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0 || i == j) {
                continue;
            }
            //交换：避免第二个循环。
            int tmp = nums[j];
            nums[j++] = nums[i];
            nums[i] = tmp;
        }
        return nums.clone();
    }
}
