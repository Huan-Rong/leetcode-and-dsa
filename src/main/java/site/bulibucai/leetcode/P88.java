package site.bulibucai.leetcode;

import java.util.Arrays;

/**
 * 题目链接：https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 解题要点：
 * 1.没有要求原地操作，因此可以使用提高空间复杂度。
 * 2.m 和 n 表示数组的元素个数，这其实也是一种逻辑分割数组，即数组的左边是有元素的，数组的右边是没有元素的。
 * 3.数组是可以双向遍历的。
 * 4.题目明确说明了 nums1.length == m + n
 */
public class P88 {
    /**
     * 分析：
     * 1.将 nums2 直接合并在 nums1 的尾部，再进行排序。
     * 2.时间复杂度：O((n+m)log(n+m))，具体需要考虑排序的性能。
     * 3.空间复杂度：O(1)。
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 分析：
     * 1.时间复杂度：O(m+n)。题目没有要求原地操作，因此可以使用复杂度高一些的方法。
     * 2.空间复杂度：O(m)。
     * 3.这个解法提高了空间复杂度，显然是没有充分利用 nums1 数组的长度是足够的这一特点。
     */
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);

        int i = 0;//index for tmp
        int j = 0;//index for nums2
        int k = 0;//index for nums1
        //这段"比较赋值"的核心代码需要非常熟练。
        while (i < m && j < n) {
            nums1[k++] = tmp[i] < nums2[j] ? tmp[i++] : nums2[j++];
        }
        if (i < m) {
            System.arraycopy(tmp, i, nums1, k, m + n - i - j);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, m + n - i - j);
        }
        return nums1;
    }

    /**
     * 分析：
     * 1.时间复杂度：O(m+n)。
     * 2.空间复杂度：O(1)。
     */
    public static int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
        // i > 0 的情况不需要做多余的复制操作。

        return nums1;
    }
}
