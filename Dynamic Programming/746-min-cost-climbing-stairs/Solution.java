/**
 * # Problem Descriptions
 * 
 * ## [746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs)
 * 
 * 746. Min Cost Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a
 * staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * ---
 * 
 */
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++)
            minCost[i] = Math.min(minCost[i-2], minCost[i-1]) + cost[i];

        return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
    }
}