/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">LeetCode</a>
 */
class Solution {

    private static final Set VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    private static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }

    private static void swap(char[] chars, int p1, int p2) {
        char tmp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = tmp;
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;

        while (p1 < p2) {
            while (p1 < p2 && !isVowel(chars[p1])) p1++;
            while (p1 < p2 && !isVowel(chars[p2])) p2--;
            if (p1 < p2) {
                swap(chars, p1, p2);
                p1++;
                p2--;
            }
        }

        return String.valueOf(chars);
    }
}