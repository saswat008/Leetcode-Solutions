class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int l=-1;
        for (int i=0;i<size;i++) {
            if(nums[i]==val) {
                if(l==-1) {
                    l=i;
                }
            } else {
                if(l!=-1) {
                    nums[l++] = nums[i];
                }
            }
        }
        if(l==-1) {
            l=size;
        }
        return l;
    }
}

// Time = O(n)
// Space = O(1)
