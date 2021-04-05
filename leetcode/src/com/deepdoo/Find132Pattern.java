package com.deepdoo;

public class Find132Pattern {
    public boolean solution(int[] nums) {
        if(nums.length <= 0) {
            return false;
        }
        int min = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if(max > min && nums[i] < nums[max] && nums[i] > nums[min]) {
                return true;
            }
            if(nums[i] > max) {
                max = i;
            }
            if(nums[i] < min) {
                min = i;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};
        Find132Pattern find132Pattern = new Find132Pattern();

        System.out.println(find132Pattern.solution(nums));
    }
}
