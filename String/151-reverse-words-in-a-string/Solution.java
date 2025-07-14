/**
 * # Problem Descriptions
 * 
 * ## [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)
 * 
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 * ---
 * 
 */
class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        // initialize
        int start = 0, end = 0, i = s.length()-1;
        
        while (i >= 0) {
            // find end of next word
            while (i >= 0 && s.charAt(i) == ' ') i--;
            end = i+1;

            // find start of next word
            while (i >= 0 && s.charAt(i) != ' ') i--;
            start = i+1;

            if (start != end) { // store word
                sb.append(s.substring(start, end));
                sb.append(' ');
            }
        }
        
        // skip last space
        sb.setLength(sb.length() - 1);
        
        return sb.toString();
    }
}