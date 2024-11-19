class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int tempArr[] = new int[m+n];
        int k = 0;
        while(i<m && j<n) {
            if(nums1[i]<=nums2[j]) {
                tempArr[k++] = nums1[i++];
            } else {
                tempArr[k++] = nums2[j++];
            }
        }
        while(i<m) {
            tempArr[k++] = nums1[i++];
        }
        while(j<n) {
            tempArr[k++] = nums2[j++];
        }

        for(int l=0; l<m+n; l++) {
            nums1[l] = tempArr[l];
        }
    }
}

// Time = O(m+n)
// Space = O(m+n) -- Not optimized
