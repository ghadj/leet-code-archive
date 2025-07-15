/**
 * String Compression
 *
 * @see <a href="https://leetcode.com/problems/string-compression">LeetCode</a>
 */
class Solution {

    private int addChar(char[] chars, char c, int count, int index) {
        chars[index++] = c;

        if (count == 1) return index;
        
        for (char digit : Integer.toString(count).toCharArray())
            chars[index++] = digit;
        return index;
    }

    public int compress(char[] chars) {
        int index = 0;
        int count = 1;

        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                index = addChar(chars, chars[i - 1], count, index);
                count = 1;
            }
        }
        return index;
    }
}