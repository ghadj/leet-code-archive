/**
 * # [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 * 
 */
class Solution {

    private static final Map<Character, String> digitToLetters = new HashMap<>();

    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, index + 1, currentCombination, result);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // backtrack
        }
    }

// Manual calculation of mapping digits to letters

//    public void letterCombinations(String digits, int index, String currentString, List<String> result) {
//        if (index == digits.length()) {
//            result.add(currentString);
//            return;
//        }
//        
//        int digit = digits.charAt(index) - '0';
//        int keyCount = digit == 7 || digit == 9 ? 4 : 3;
//        int startCharInt = (digit-2) * 3);
//        if (digit > 7) startCharInt++;
//        char startCharacter = (char) ('a' + startCharInt);
//
//        for (int i = 0; i < keyCount; i++) {
//            char character_i = (char) (startCharacter + i);
//            String newString = currentString + character_i;
//            letterCombinations(digits, index+1, newString, result);
//        }
//    }
//
//    public List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        if (digits.isEmpty()) return result;
//        letterCombinations(digits, 0, "", result);
//        return result;
//    }

}