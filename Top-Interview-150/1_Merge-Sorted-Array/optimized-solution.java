/*
Intuition :
When you want to merge two sorted arrays, the goal is to create a new sorted array that combines elements from both arrays. Since both arrays are already sorted, you can compare the largest unmerged elements of both arrays and place the larger one at the end of the combined array. This way, you maintain the sorted order as you merge the elements.

Approach :
1. Start from the End: 
   Since nums1 has enough space at the end to hold all elements from both arrays, we will start merging from the last index. This allows us to avoid overwriting any values we haven't processed yet.
2. Use Three Pointers:
   - Pointer i for the last element in the actual data of nums1.
   - Pointer j for the last element in nums2.
   - Pointer k for the last position in nums1 where the next largest value should go.
3. Compare and Place:
   - Compare the current elements pointed to by i and j.
   - Place the larger element at the position k in nums1.
   - Move the corresponding pointer (i or j) backward and also decrement k.
4. Handle Remaining Elements:
   If there are still elements left in nums2, copy them over to nums1. If nums1 has elements left, they are already in the correct position.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

// Time: O(m+n)
// Space: O(1)
