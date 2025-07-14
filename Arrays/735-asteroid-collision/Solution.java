/**
 * # [Asteroid Collision](https://leetcode.com/problems/asteroid-collision)
 * 
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign represents its
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the
 * same direction will never meet.
 * 
 */
class Solution {

    private boolean isOppositeSign(int a, int b) {
        return a * b < 0;
    }

    private boolean hasSmallerAbsValue(int a, int b) {
        return Math.abs(a) < Math.abs(b);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                while (!st.isEmpty() && isOppositeSign(st.peek(), asteroid)
                        && hasSmallerAbsValue(st.peek(), asteroid)) {
                    st.pop();
                }

                if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                } else if (st.peek() == -asteroid) {
                    st.pop();
                }
            }
        }

        int[] result = new int[st.size()];
        int index = result.length - 1;
        while (!st.isEmpty()) {
            result[index--] = st.pop();
        }

        return result;
    }
}