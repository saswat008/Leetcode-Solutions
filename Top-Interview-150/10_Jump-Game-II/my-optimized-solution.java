class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int minSteps = 0;
        int l = 0;
        int r = 0;
        int farthest = nums[0];
        while(r < n-1) {
            for (int i=l; i<=r; i++) {
                farthest = Math.max(farthest, nums[i]+i);
            }
            l = r+1;
            r = farthest;
            minSteps++;
        }
        return minSteps;
    }
}

Time: O(n)
Space: O(1)
