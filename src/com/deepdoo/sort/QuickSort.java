package com.deepdoo.sort;

import java.util.Arrays;

/**
 * @author caoyunzhou
 */
public class QuickSort extends Sort {

    @Override
    public void sort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    public void qSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i, j;
        j = left;
        i = j + 1;

        while (i <= right && j < right - 1) {
            if (nums[i] <= nums[left]) {
                swap(nums, i, j + 1);
                j++;
            }
            i++;
        }
        swap(nums, left, j);

        qSort(nums, 0, j - 1);
        qSort(nums, j + 1, right);
    }

    public static void main(String[] args) {

        int[] nums = {21, 5, 9, 12, 54, 20, 3};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);

        System.out.println(Arrays.toString(nums));
    }

}
