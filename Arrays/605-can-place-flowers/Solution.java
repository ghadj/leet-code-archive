/**
 * # [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return true if n new flowers can be planted in the flowerbed without violating the
 * no-adjacent-flowers rule and false otherwise
 * 
 */
class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if (n == 0) break;

            if (flowerbed[i] > 0) continue;
            
            int prev = Math.max(0, i-1);
            if (flowerbed[prev] > 0) continue;
            
            int next = Math.min(flowerbed.length-1, i+1);
            if (flowerbed[next] > 0) continue;

            flowerbed[i] = 1;
            n--;
        }
        return n == 0;
    }
}