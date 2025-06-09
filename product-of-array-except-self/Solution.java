/**
 * ---
 * [https://leetcode.com/problems/product-of-array-except-self/]
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * ---
 */
class Solution {

    public int[] productExceptSelf(int[] nums) {
        // case 1. all non-zero: total product divided by current value
        // case 2. one zero: all zeroes except index of zero (total product)
        // case 3. at least two zeroes: all zeroes

        int countZeroes = 0; // total number of zeroes
        int total = 1; // total product excluding 1 zero

        // first pass (count zeroes)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                countZeroes++;
            else
                total *= nums[i];

            if (countZeroes > 1) {
                total = 0;
                break;
            }
        }

        // calculate result
        int[] result = new int[nums.length];

        // case 3.
        if (countZeroes > 1)
            return result;

        for (int i = 0; i < result.length; i++) {
            if (countZeroes == 0) // case 1.
              result[i] = nums[i] == 0 ? 0 : total / nums[i];
            else // case 2.
              result[i] = nums[i] == 0 ? total : 0;
        }

        return result;
    }
}