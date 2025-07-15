/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum average value
 * and return this value
 *
 * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i">LeetCode</a>
 */
class Solution {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        double max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max/k;
    }
}