/**
 * # Problem Descriptions
 * 
 * ## [2390. Removing Stars From a String](https://leetcode.com/problems/removing-stars-from-a-string)
 * 
 * 2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 * 
 * In one operation, you can:
 * - Choose a star in s.
 * - Remove the closest non-star character to its left, as well as remove the star itself.
 * 
 * Return the string after all stars have been removed.
 * ---
 * 
 * ---
 * 
 * ## [2390. Removing Stars From a String](https://leetcode.com/problems/removing-stars-from-a-string)
 * 
 * 2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 * 
 * In one operation, you can:
 * - Choose a star in s.
 * - Remove the closest non-star character to its left, as well as remove the star itself.
 * 
 * Return the string after all stars have been removed.
 * ---
 * 
 */
class Solution {

    // alternative solution without stack- still very efficient

    // note: StringBuilder.insert(0, ...) is an O(n) operation 
    // each time it's called; thus here used append and reverse

    public String removeStars(String s) {
        char[] cs = s.toCharArray();
        int i, j = 0;
        StringBuilder sb = new StringBuilder();
        
        for (i = cs.length-1; i >= 0; i--) {
            if (cs[i] == '*')
                j++;
            else if (j > 0)
                j--;
            else
                sb.append(cs[i]);
        }

        return sb.reverse().toString();
    }
}
