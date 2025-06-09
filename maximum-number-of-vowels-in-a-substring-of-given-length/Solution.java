/**
 * ---
 * [https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length]
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring
 * of s with length k.
 * ---
 */
class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }

    public int maxVowels(String s, int k) {
        int index = 0;
        int currentCount = 0;

        // initialize substring
        while (index <= k-1) {
            currentCount += isVowel(s.charAt(index)) ? 1 : 0;
            index++;
        }

        // sliding window
        int maxCount = currentCount;
        while(index < s.length()) {
            if (isVowel(s.charAt(index))) currentCount++;
            if (isVowel(s.charAt(index-k))) currentCount--;            
            maxCount = Math.max(maxCount, currentCount);
            index++;
        }
        return maxCount;
    }
}