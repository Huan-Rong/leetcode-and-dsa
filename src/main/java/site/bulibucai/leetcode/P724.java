package site.bulibucai.leetcode;

import java.util.Arrays;

/**
 * 题目链接：https://leetcode-cn.com/problems/find-pivot-index/
 */
public class P724 {
    /**
     * 分析：
     * 1.使用两层循环。
     * 2.空间复杂度：O(1)。
     * 3.时间复杂度：
     * 3.1 如果不存在中心索引，则时间复杂度为：O(n^2)
     * 3.2 如果存在中心索引，那么最好情况时间复杂度为 O(n)，最坏情况时间复杂度为 O(n^2)，平均情况时间复杂度为 O(n^2)。
     */
    public static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //计算左侧和
            int leftSum = 0;
            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                leftSum += nums[leftIndex];
            }
            // 计算右侧和
            int rightSum = 0;
            for (int rightIndex = i + 1; rightIndex < nums.length; rightIndex++) {
                rightSum += nums[rightIndex];
            }
            //判断是否存在 pivotIndex
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 分析：
     * 1.官方题解：前缀和
     * 2.时间复杂度：O(n)。
     * 3.空间复杂度：O(1)。
     */
    public static int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();

        for (int i = 0, leftSum = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == total) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
