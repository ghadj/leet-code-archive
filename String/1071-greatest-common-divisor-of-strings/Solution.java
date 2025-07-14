/**
 * # [Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings)
 * 
 * For two strings s and t, we say "t divides s" if and only if
 * s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * 
 * Given two strings str1 and str2, return the largest string x such that x divides
 * both str1 and str2.
 * 
 */
class Solution {

    public String gcdOfStrings(String str1, String str2) {
        
        // Since both strings contains multiples of the identical segment base, 
        // their concatenation must be consistent, regardless of the order
        // Check if str1 + str2 is equal to str2 + str1
        if (!(str1 + str2).equals(str2 + str1))
            return ""; // No common divisor

        // Calculate the GCD of lengths 
        // *see editorial for proof that GCD string has length equal to the actual GCD 
        // of string lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 with the length of the GCD
        return str1.substring(0, gcdLength);
    }

    public int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

}