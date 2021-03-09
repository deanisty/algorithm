package com.deepdoo;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author caoyunzhou
 */
public class RemoveDuplicates {
    public String solution(String S) {
        if(S.length() <= 0) {
            return S;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if(!stack.empty() && (S.charAt(i) == stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(S.charAt(i));
        }

        char[] res = new char[stack.size()];

        while (!stack.empty()) {
            res[stack.size() - 1] = stack.pop();
        }

        return new String(res);
    }

    public static void main(String[] args) {
        String s = "abbabffbaf";
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        System.out.println(removeDuplicates.solution(s));
    }
}
