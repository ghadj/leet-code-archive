/**
 * [https://leetcode.com/problems/two-sum]
 * Two Sum
 * Given an array of integers nums and an integer target, return indices of
 * the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int i, current, complement;

        for (i = 0; i < nums.length; i++) {
            current = nums[i];
            complement = target - current;
            if (map.containsKey(complement))
                return new int[] {i, map.get(complement)};

            map.put(current, i);
        }

        return new int[0];
    }
}
