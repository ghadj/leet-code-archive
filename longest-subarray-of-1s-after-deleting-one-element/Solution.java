/**
 * ---
 * [https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element]
 * 1493. Longest Subarray of 1's After Deleting One Element
 * ---
 */
class Solution {

    public int longestSubarray(int[] nums) {
        int prevSubArray = 0;
        int currentSubArray = 0;
        int maxSubArray = 0;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1) {
                currentSubArray++;
            } else {
                maxSubArray = Math.max(prevSubArray + currentSubArray, maxSubArray);
                prevSubArray = currentSubArray;
                currentSubArray = 0;
            }
        }

        maxSubArray = Math.max(prevSubArray + currentSubArray, maxSubArray);
        
        // if no zero encountered
        if (prevSubArray == 0 && currentSubArray == nums.length)
            maxSubArray = currentSubArray - 1;

        return maxSubArray;
    }
}