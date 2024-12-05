class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int maxSum = 0;
        for(int i=0; i<size; i++){
            int buyPrice = prices[i];
            int max = prices[i];
            int sum = 0;
            for(int j=i+1; j<size; j++) {
                if (prices[j] >= max) {
                    max = prices[j];
                } else {
                    sum+= max - buyPrice;
                    buyPrice = prices[j];
                    max = prices[j];
                }
            }
            if (max!=buyPrice) {
                sum+= max - buyPrice;
            }
            maxSum = (maxSum > sum)? maxSum : sum ;
        }
        return maxSum;
    }
}

// Time = O(n*n) (Not optimized)
// Space = O(1) 
