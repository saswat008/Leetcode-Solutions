class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int maxSumArr[] = new int[size];
        maxSumArr[size-1] = 0;
        for(int i=size-2; i>=0; i--) {
            int tempSum = prices[i+1] - prices[i] + maxSumArr[i+1];
            maxSumArr[i] = (tempSum > maxSumArr[i+1]) ? tempSum : maxSumArr[i+1];
        }
        return maxSumArr[0];
    }
}

// Time = O(n)
// Space = O(n) (Not optimized)
