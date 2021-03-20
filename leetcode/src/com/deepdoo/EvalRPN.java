package com.deepdoo;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 * 示例1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * 提示：
 *
 * 1 <= tokens.length <= 104
 * tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvalRPN {

    String add = "+";
    String minus = "-";
    String multiple = "*";
    String divide = "/";

    Stack<String> ops = new Stack<>();

    public static void main(String[] args) {
        String[] operands = {"3", "5", "+", "6", "*", "2", "/"};

        EvalRPN evalRPN = new EvalRPN();

        System.out.println(evalRPN.solution(operands));

    }

    public int solution(String[] tokens) {
        int op1, op2;

        if(tokens.length <= 0) {
            return 0;
        }

        for (String token : tokens) {
            if (!isOperator(token)) {
                ops.push(token);
            } else {
                op2 = Integer.parseInt(ops.pop());
                op1 = Integer.parseInt(ops.pop());

                ops.push(calculate(op1, op2, token));
            }

        }

        return Integer.parseInt(ops.pop());
    }

    public String calculate(int op1, int op2, String operator) {
        if(operator.equals(add)) {
            return String.valueOf(op1 + op2);
        } else if(operator.equals(minus)) {
            return String.valueOf(op1 - op2);
        } else if(operator.equals(multiple)) {
            return String.valueOf(op1 * op2);
        } else {
            return String.valueOf(op1 / op2);
        }
    }

    public boolean isOperator(String c) {
        return c.equals(add) || c.equals(minus) || c.equals(multiple) || c.equals(divide);
    }
}
