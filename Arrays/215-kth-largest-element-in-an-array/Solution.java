
/**
 * # [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
