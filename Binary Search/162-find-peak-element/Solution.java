/**
 * # [Find Peak Element](https://leetcode.com/problems/find-peak-element)
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 */
class Solution {

    private boolean isPeak(Integer a, int b, Integer c) {
        if (a == null && c == null) return true;
        if (a == null) return b > c;
        if (c == null) return b > a;
        return a < b && b > c;
    }

    public int findPeakElement(int[] nums) {
        int up = nums.length, low = 0, mid = (up - low) / 2 + low;

        while (up >= low) {
            Integer left = mid > 0 ? nums[mid - 1] : null;
            Integer right = mid < nums.length - 1 ? nums[mid + 1] : null;

            if (isPeak(left, nums[mid], right)) return mid;
            else if (left != null && left > nums[mid]) up = mid - 1;
            else low = mid + 1;

            mid = (up - low) / 2 + low;
        }
        return -1;
    }
}