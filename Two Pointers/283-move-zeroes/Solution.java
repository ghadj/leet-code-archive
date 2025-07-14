/**
 * # Problem Descriptions
 * 
 * ## [283. Move Zeroes](https://leetcode.com/problems/move-zeroes)
 * 
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * ---
 * 
 */
class Solution {

    // no swapping, single for loop
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move non-zero elements to the front
        for (int num : nums)
            if (num != 0) nums[insertPos++] = num; // Insert non-zero element

        // Fill the remaining positions with zeros
        while (insertPos < nums.length) 
            nums[insertPos++] = 0;
    }

    // use two while loops for separate pointers
    public void moveZeroes_2(int[] nums) {
        int zeroIndex = 0, nonZeroIndex = 0;

        while(zeroIndex < nums.length && nonZeroIndex < nums.length) {
            while (zeroIndex < nums.length && nums[zeroIndex] != 0)
                zeroIndex++;

            nonZeroIndex = zeroIndex +1 ;
            while (nonZeroIndex < nums.length && nums[nonZeroIndex] == 0)
                nonZeroIndex++;

            if (zeroIndex >= nums.length || nonZeroIndex >= nums.length) break;

            // swap
            int tmp = nums[zeroIndex];
            nums[zeroIndex] = nums[nonZeroIndex];
            nums[nonZeroIndex] = tmp;
        }
    }
}