/*
Intuition
The intuition behind this solution is to iterate through the array and keep track of two pointers: index and i. 
The index pointer represents the position where the next non-target element should be placed, while the i pointer iterates through the array elements. 
By overwriting the target elements with non-target elements, the solution effectively removes all occurrences of the target value from the array.

Approach
1. Initialize index to 0, which represents the current position for the next non-target element.
2. Iterate through each element of the input array using the i pointer.
3. For each element nums[i], check if it is equal to the target value.
   - If nums[i] is not equal to val, it means it is a non-target element.
   - Set nums[index] to nums[i] to store the non-target element at the current index position.
   - Increment index by 1 to move to the next position for the next non-target element.
4. Continue this process until all elements in the array have been processed.
5. Finally, return the value of index, which represents the length of the modified array.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int swapPos = 0; // int index = 0;
        for (int i=0; i<size; i++) {
            if(nums[i]!=val) {
                nums[swapPos++] = nums[i];  // nums[index++] = nums[i];
            }
        }
        return swapPos;  // return index;
    }
}

// Time = O(n)
// Space = O(1)
