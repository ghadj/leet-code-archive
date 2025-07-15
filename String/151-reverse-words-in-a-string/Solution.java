/**
 * Given an input string s, reverse the order of the words.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">LeetCode</a>
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