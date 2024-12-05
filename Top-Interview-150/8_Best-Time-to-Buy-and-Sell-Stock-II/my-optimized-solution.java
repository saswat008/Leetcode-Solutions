class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int maxSum = 0;
        for(int i=size-2; i>=0; i--) {
            int tempSum = prices[i+1] - prices[i] + maxSum;
            maxSum = (tempSum > maxSum) ? tempSum : maxSum;
        }
        return maxSum;
    }
}

// Time : O(n)
// Space : O(1)
