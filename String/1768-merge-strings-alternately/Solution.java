/**
 * # Problem Descriptions
 * 
 * ## [1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately)
 * 
 * 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters
 * in alternating order, starting with word1. If a string is longer than the
 * other, append the additional letters onto the end of the merged string.
 * ---
 * 
 */
class Solution {
    
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(index < word1.length() && index < word2.length()) {
            sb.append(word1.charAt(index));
            sb.append(word2.charAt(index));
            index++;
        }

        // add remaining characters
        sb.append(word1.substring(index, word1.length()));
        sb.append(word2.substring(index, word2.length()));
        return sb.toString();
    }
}