package site.bulibucai.leetcode;

import java.util.HashMap;

/**
 * 题目链接：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 *
 * 解题要点：
 * 1.递归思想。
 * 2.使用基于缓存的递归，来减少重复计算。
 * 3.从数学问题的角度来解决问题。
 * <p>
 *
 * 扩展：
 * 1.研究递归的复杂度分析。
 * 2.研究树降维为线性表的案例。
 *
 */
public class P70 {

    private static HashMap<Integer, Integer> cache = new HashMap<>();

    /**
     * 分析：
     * 1.将上楼梯改为下楼梯的递归思路。
     * 2.这是无缓存的递推，即缓存中间计算结果，造成重复计算的问题。
     * 3.时间复杂度为：O(2^n)，即指数级的时间复杂度。
     * 4.空间复杂度为：O(n)，这里是指递归的深度，即方法栈的深度。
     * 5.当递归树的深度过大时，容易爆栈。
     * <p>
     * 重复计算造成的资源浪费的分析：
     * 1.递归的重复计算并不会导致递归深度的变化，但是会导致递归树变得粗壮。
     * 2.另外，递归重复计算会导致方法栈中不断的压入弹出方法帧，即对内存资源和 CPU 资源都造成了浪费。
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 分析：
     * 1.基于缓存的递归思路，避免了重复计算。
     * 2.避免了递归树变得粗壮，使得递归树向线性表降维。
     * 3.时间复杂度：由于递归树向线性表降维，其时间复杂度为 O(n)。
     * 4.空间复杂度：由于递归树向线性表降维，其空间复杂度为 O(n)。
     * 5.如果递归树的深度过大，容易爆栈。
     */
    public static int climbStairs1(int n) {
        //如果缓存已有计算结果，则直接返回。
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        //如果缓存不存在计算结果，则进行递归计算，并缓存结果。
        if (n <= 2) {
            return n;
        }
        int tmp = climbStairs1(n - 1) + climbStairs1(n - 2);
        cache.put(n, tmp);
        return tmp;
    }

    /**
     * 分析：
     * 1.将递归问题转换为数学问题，求解斐波那契数列。
     * 2.时间复杂度：O(n)。
     * 3.空间复杂度：O(1)。
     */
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * todo: 使用动态规划。
     */
    public static int climbStairs3(int n) {
        return 0;
    }
}
