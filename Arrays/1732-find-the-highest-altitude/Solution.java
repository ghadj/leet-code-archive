
/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points
 * at different altitudes. The biker starts his trip on point 0 with altitude
 * equal 0.
 *
 * You are given an integer array gain of length n where gain[i] is the net gain
 * in altitude between points i and i + 1 for all (0 <= i < n). Return the
 * highest altitude of a point.
 *
 * @see <a href="https://leetcode.com/problems/find-the-highest-altitude">LeetCode</a>
 */
class Solution {

    public int largestAltitude(int[] gains) {
        int altitude = 0;
        int max = 0;
        for (int gain : gains) {
            altitude += gain;
            max = Math.max(max, altitude);
        }
        return max > 0 ? max : 0;
    }
}
