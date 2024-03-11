package leetcode;

/**
 * 136. Single Number
 * Easy
 * Topics
 * Companies
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class singlenums {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
            System.out.println(result);
        }
        return result;
    }
}
