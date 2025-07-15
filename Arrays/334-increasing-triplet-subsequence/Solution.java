/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * @see <a href="https://leetcode.com/problems/increasing-triplet-subsequence">LeetCode</a>
 */
class Solution {

    public boolean increasingTriplet(int[] nums) {
       int min = Integer.MAX_VALUE;
       int mid = Integer.MAX_VALUE;

       for(int n : nums)
           if(n <= min) min = n;
           else if(n <= mid) mid = n;
           else return true;

       return false;
    }
}