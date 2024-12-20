/*
Intuition
Imagine you have a car, and you have some distance to travel (the length of the array). This car has some amount of gasoline, and as long as it has gasoline, 
it can keep traveling on this road (the array). Every time we move up one element in the array, we subtract one unit of gasoline. 
However, every time we find an amount of gasoline that is greater than our current amount, we "gas up" our car by replacing our current amount of gasoline with this new amount. 
We keep repeating this process until we either run out of gasoline (and return false), or we reach the end with just enough gasoline (or more to spare), in which case we return true.
Note: We can let our gas tank get to zero as long as we are able to gas up at that immediate location (element in the array) that our car is currently at.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        int i = 0;
        if (i==lastIndex) 
            return true;
        int jumpIndex = 1;
        while (nums[i] > 0) {
            if (lastIndex-nums[i] <= i) { 
                return true;
            } else {
                if (--nums[i] < nums[i+jumpIndex]) {
                    i+=jumpIndex;
                    jumpIndex=1;
                } else {
                    jumpIndex++;
                }
            }
        }
        return false;
    }
}

// Time : O(n)
// Space : O(1)
