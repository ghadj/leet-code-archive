/**
 * Two strings are considered close if you can attain one from the other using
 * the following operations:
 * - Operation 1: Swap any two existing characters.
 * - Operation 2: Transform every occurrence of one existing character into another existing character,
 * and do the same with the other character.
 *
 * @see <a href="https://leetcode.com/problems/determine-if-two-strings-are-close">LeetCode</a>
 */
class SolutionA {

    private int[] getCharFrequency(String s) {
        int[] freq = new int[26];
        for (byte b : s.getBytes())
            freq[b-'a']++; // note: 'a' = 97
        return freq;
    }

    private boolean containSameCharacters(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length && i < arr2.length; i++)
            if (arr1[i] > 0 ^ arr2[i] > 0) return false;
        return true;
    }

    private boolean sameOccurances(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
    }

    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = getCharFrequency(word1);
        int[] freq2 = getCharFrequency(word2);
        return containSameCharacters(freq1, freq2) && sameOccurances(freq1, freq2);
    }
}
