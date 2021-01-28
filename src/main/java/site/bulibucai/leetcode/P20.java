package site.bulibucai.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 题目链接：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class P20 {

    /**
     * 分析：
     * 1.基于顺序栈的思路实现。
     * 2.时间复杂度：O(n)。
     * 3.空间复杂度：自实现的 ArrayStack 的栈容量为 10000，虽然是一个常量，但也是题目的上限值，因此这里可以认为该解法的空间复杂度为 O(n)。
     */
    public static boolean isValid(String s) {
        ArrayStack arrayStack = new ArrayStack();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '{':
                case '[':
                case '(':
                    arrayStack.push(aChar);
                    break;
                case '}':
                    if (arrayStack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (arrayStack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (arrayStack.pop() != '(') {
                        return false;
                    }
            }
        }

        return arrayStack.getLength() == 0;
    }

    /**
     * 分析：
     * 1.对第一种解法的实现细节进行优化，主要包含以下几点：
     * 1.1 数学优化。第一种解法没有考虑有效字符串所包含的字符数必定是偶数。
     * 1.2 代码逻辑优化。第一种解法的代码实现中过多地出现了各种括号的字符常量， 也就是说没有对这部分逻辑进行抽象优化。
     * 1.3 使用编程语言提供的 API。第一种解法的代码实现中使用了自行定义的 ArrayStack，但其实可以使用 JDK 提供的 API，以此简化代码量。
     */
    public static boolean isValid2(String s) {
        //数学优化。
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        //一种奇怪的初始化方法。
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //如果字符是右类，则判断是否匹配栈顶字符。
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                //如果字符不是右类，则压入栈。
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

/**
 * 基于数组的栈实现。
 * <p>
 * 实现要点：
 * 1.栈顶指针指向下一个可以入栈的地址。
 * 2.入栈要考虑栈满的情况，同时需要修改栈顶指针。
 * 3.出栈要考虑栈空的情况，同事需要修改栈顶指针。
 */
class ArrayStack {
    private final int CAPACITY = 10000;
    private final char[] stack = new char[CAPACITY];

    private int top = 0;

    public char pop() {
        if (top == 0) {
            return '\0';
        }
        return stack[--top];
    }

    public void push(char c) {
        if (CAPACITY == top) {
            return;
        }
        stack[top++] = c;
    }

    public int getLength() {
        return this.top;
    }
}
