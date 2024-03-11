package leetcode;
/**Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
**/
public class targetarray {
        public int[] twoSum(int[] nums, int target) {
            int[] arr = new int[2];
            int j = 1;
// j=1
            while(j < nums.length){
                for(int i = 0; i+j < nums.length; i++){
                    if(target == nums[i]+nums[i+j]){
                        arr[0] = i;
                        arr[1]= i+j;
                        return arr;
                    }
                }
                j++;
            }
            return arr;
        }
}
