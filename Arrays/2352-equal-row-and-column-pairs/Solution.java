/**
 * # [Equal Row and Column Pairs](https://leetcode.com/problems/equal-row-and-column-pairs)
 * 
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that
 * row ri and column cj are equal.
 * 
 * -not fully happy though-
 * 
 */
class Solution {

    private String columnToString(int[][] arr, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][col]);
            sb.append(',');
        }
        return sb.toString();
    }

    private String rowToString(int[][] arr, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[row].length; i++) {
            sb.append(arr[row][i]);
            sb.append(',');
        }
        return sb.toString();
    }

    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            String s = rowToString(grid, i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            String s = columnToString(grid, i);
            Integer val = map.get(s);
            if (val != null)
                count += val;
        }
        return count;
    }
}