/**
 * ---
 * [https://leetcode.com/problems/kids-with-the-greatest-number-of-candies]
 * 1431. Kids With the Greatest Number of Candies
 * Return a boolean array result of length n, where result[i] is true if, after giving
 * the ith kid all the extraCandies, they will have the greatest number of candies among
 * all the kids, or false otherwise.
 * ---
 */
class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies)
            if (candy > max)
                max = candy;

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) 
            result.add(candy + extraCandies >= max);

        return result;
    }
}