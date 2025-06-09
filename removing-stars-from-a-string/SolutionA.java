/**
 * ---
 * [https://leetcode.com/problems/removing-stars-from-a-string]
 * 2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 * - Choose a star in s.
 * - Remove the closest non-star character to its left, as well as remove the star itself.
 *
 * Return the string after all stars have been removed.
 * ---
 */
class SolutionA {

    // note: here the stack is only used for reversing the resulting string.
    // alternatively the stack could be used for additions/removals depending
    // on the current character.

    public String removeStars(String s) {
        char c;
        int count = 0;
        int index;
        Stack<Character> stack = new Stack<>();
        for (index = s.length()-1; index >= 0; index--) {
            c = s.charAt(index);
            if (c == '*') {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                stack.push(c);
            }
        }

        index = 0;
        char[] result = new char[stack.size()];
        while(!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return String.copyValueOf(result);
    }
}
