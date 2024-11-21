class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int size = nums.length;
        for(int i=0;i<size;i++) {
            if(k==0 || k==1 || nums[k-2] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k ;
    }
}

/*
The goal of this function is to remove duplicates from the nums vector while keeping at most two occurrences of any element. The function returns the length of the modified vector after removing duplicates.

Here's the approach implemented in the code:

Initialize an integer variable k to 0. This variable will keep track of the current position in the modified nums vector.

Use a for loop to iterate through each element i in the nums vector using the range-based for loop.

Inside the loop, check the following conditions:

- k == 0: This condition ensures that the first element is always included in the modified vector.
- k == 1: This condition ensures that the second element is always included in the modified vector.
- nums[k-2] != nums[i]: This condition checks if the current element i is not the same as the element two positions before the current position k. 
                        This ensures that only two occurrences of any element are included in the modified vector.
                        If any of the above conditions are met, copy the current element nums[i] to the nums[k] position in the modified vector, and increment k by 1 to move to the next position.

Repeat this process for all elements in the nums vector.

Finally, return the value of k, which represents the length of the modified vector with duplicates removed.

This approach effectively modifies the nums vector in place, removing duplicates while keeping at most two occurrences of each element. 
The function returns the length of the modified vector, which can be used to access the unique elements in the first k positions of the vector

Complexity
Time complexity:0(N)
Space complexity:0(1)
*/
