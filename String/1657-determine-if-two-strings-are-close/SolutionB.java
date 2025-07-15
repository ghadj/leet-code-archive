/**
 * Two strings are considered close if you can attain one from the other using
 * the following operations:
 * - Operation 1: Swap any two existing characters.
 * - Operation 2: Transform every occurrence of one existing character into another existing character,
 * and do the same with the other character.
 *
 * @see <a href="https://leetcode.com/problems/determine-if-two-strings-are-close">LeetCode</a>
 */
class SolutionB {

    private Map<Character, Integer> createCharFrequencyMap(String str) {
        List<Character> chars = convertToList(str);
        return createFrequencyMap(chars);
    }

    private List<Character> convertToList(String str) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            chars.add(str.charAt(i));
        return chars;
    }

    private <T> Map<T, Integer> createFrequencyMap(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for (T val : list)
            map.put(val, map.getOrDefault(val, 0) + 1);
        return map;
    }

    private boolean containSameCharacters(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        return map1.keySet().equals(map2.keySet());
    }

    private boolean sameOccurances(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size())
            return false;
    
        int count;
        Map<Integer, Integer> map = createFrequencyMap(list1);
        for (Integer num : list2) {
            count = map.getOrDefault(num, 0);
            if (count == 0)
                return false;
            map.put(num, count - 1);
        }

        for (Integer val : map.values())
            if (val > 0)
                return false;

        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = createCharFrequencyMap(word1);
        Map<Character, Integer> map2 = createCharFrequencyMap(word2);
        List<Integer> vals1 = new ArrayList<>(map1.values());
        List<Integer> vals2 = new ArrayList<>(map2.values());
        return containSameCharacters(map1, map2) && sameOccurances(vals1, vals2);
    }
}