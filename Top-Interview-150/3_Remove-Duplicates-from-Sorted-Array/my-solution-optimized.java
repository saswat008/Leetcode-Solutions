class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int k=0;
        for (int i=0; i<size; i++) {
            if(nums[i]!=nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }
}

// Time = O(n)
// Space = O(1)

/*
Hint 1
In this problem, the key point to focus on is the input array being sorted. As far as duplicate elements are concerned, what is their positioning in the array when the given array is sorted? 
If we know the position of one of the elements, do we also know the positioning of all the duplicate elements?

Hint 2
We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array. 
So, we ought to use a two-pointer approach here. One, that would keep track of the current element in the original array and another one for just the unique elements.

Hint 3
Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.
*/
