class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int k=0;
        int count=1;
        for(int i=1; i<size; i++) {
            if(nums[i]!=nums[k]) {
                nums[++k] = nums[i];
                count=1;
            } else {
                count++;
                if (count<=2) {
                    nums[++k] = nums[i];
                }
            }
        }
        return ++k;
    }
}

// Time = O(n)
// Space = O(1)
