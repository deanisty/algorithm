package com.deepdoo.sort;

import java.util.Arrays;

/**
 * 两两比较 大数沉底
 *
 * @author caoyunzhou
 */
public class BubbleSort extends Sort {

    @Override
    public void sort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 7, 2, 5, 9, 0};

        BubbleSort sort = new BubbleSort();

        sort.sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
