package com.deepdoo.sort;

public abstract class Sort {
    public void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public abstract void sort(int[] nums);
}
