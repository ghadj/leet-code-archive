/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 *
 * @see <a href="https://leetcode.com/problems/is-subsequence">LeetCode</a>
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int t_i = 0;
        for (Character c : s.toCharArray()) {
            while(t_i < t.length() && t.charAt(t_i) != c) t_i ++;
            if (t_i == t.length()) return false;
            t_i++;
        }
        return true;
    }
}