/**
 * # [Decode String](https://leetcode.com/problems/decode-string)
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
 * repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid. No extra white spaces, square brackets are well-formed,
 * etc.
 * 
 */
class Solution {

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private int charToInt(char c) {
        return c - '0';
    }

    public String decodeString(String s) {
        Stack<Integer> stackNums = new Stack<>();
        Stack<StringBuilder> stackSubstrings = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isDigit(c)) {
                // Build the number
                currentNum = currentNum * 10 + charToInt(c);
            } else if (c == '[') {
                // Push current number and string builder onto respective stacks
                stackNums.push(currentNum);
                stackSubstrings.push(currentStr);
                // Reset current num and str
                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                // Pop number and previous substring, repeat the string and append to previous
                int repeatCount = stackNums.pop();
                StringBuilder temp = currentStr;
                currentStr = stackSubstrings.pop();
                // Repeat the current substring 'repeatCount' times and append it
                for (int j = 0; j < repeatCount; j++) {
                    currentStr.append(temp);
                }
            } else {
                // Append current character to the current string
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }
}
