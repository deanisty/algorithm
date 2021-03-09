package com.deepdoo.misc;

/**
 * 从25亿个数中找出出现过偶数次的那个数
 * 其他数都只出现过一次
 *
 * @author caoyunzhou
 */
public class FindEvenNumber {
    public static void solution(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor = ~nums[i] & nums[i+1];
        }

    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 88, 1234, 242,242342,12313,234234235};
    }
}
