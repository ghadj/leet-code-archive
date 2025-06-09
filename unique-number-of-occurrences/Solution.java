/**
 * ---
 * [https://leetcode.com/problems/unique-number-of-occurrences]
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the
 * array is unique or false otherwise.
 * ---
 */
class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 0);

        Set<Integer> set = new HashSet<>();
        for (Integer val : map.values()) {
            if (set.contains(val))
                return false;
            set.add(val);
        }

        return true;
    }
}