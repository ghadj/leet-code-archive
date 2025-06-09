/**
 * ---
 * [https://leetcode.com/problems/max-consecutive-ones-iii]
 * 1004. Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the
 * array if you can flip at most k 0's.
 * ---
 */
class Solution {

    public int longestOnes_1(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int zeroes = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroes++;
                while (zeroes > k) {
                    int val = nums[left++];
                    if (val == 0)
                        zeroes--;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int longestOnes_2(int[] nums, int k) {
        int max = 0, start = 0;
        List<Integer> zeros = new LinkedList<>();

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1)
                continue;
            zeros.add(index);
            if (zeros.size() > k) {
                max = Math.max(max, index - start);
                start = zeros.get(0) + 1;
                zeros.remove(0);
            }
        }
        return Math.max(max, nums.length - start);
    }
}