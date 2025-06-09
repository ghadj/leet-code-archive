/**
 * ---
 * [https://leetcode.com/problems/container-with-most-water]
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that 
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 * ---
 */
class Solution {

    private int area(int[] arr, int i, int j) {
        int h = Math.min(arr[i], arr[j]);
        int w = Math.abs(i-j);
        return h*w;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, area(height, left, right));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}