class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int tempArray[] = new int[n];
        
        if(k>=n) {
            k = k%n;
        }
        if(k==0){
            return;
        }
        for (int i=0; i<k; i++) {
            tempArray[i] = nums[n-k+i];
        }
        for (int i=0; i<n-k; i++) {
            tempArray[i+k] = nums[i];
        }
        for (int i=0; i<n; i++) {
            nums[i] = tempArray[i];
        }
    }
}

// Time = O(n)
// Space = O(n) (Not optimal)
