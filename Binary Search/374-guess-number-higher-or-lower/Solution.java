/**
 * Forward declaration of guess API.
 * 
 * ```
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 * ```
 *
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower">LeetCode</a>
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int up = n, low = 0, mid = (up - low) / 2 + low;

        while (true) {
            int guessVal = guess(mid);
            if (guessVal > 0) {
                low = mid + 1;
            } else if (guessVal < 0) {
                up = mid - 1;
            } else
                break;
            mid = (up - low) / 2 + low;
        }

        return mid;
    }

}