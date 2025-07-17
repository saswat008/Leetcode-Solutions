/*
1. Brute Force
So, the first and formost, the simplest method that comes to mind is, I can loop through the complete array using a pointer, say j, for every index i, and multiply all the elements at index j except when i == j. This would ensure that I skip the element at index i from being multiplied.

The Time Complexity for this solution would be O(n2).

Below is the Java Code for this approach.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        
        return ans;
    }
}

// Time: O(n2) Not optimized
// Space: O(1)

/*
2. Finding Prefix Product and Suffix Product
Similar to finding Prefix Sum Array, here we would intend to find the Prefix Product Array and Suffix Product Array for our original array, i.e. pre[i] = pre[i - 1] * a[i - 1] (yes, we multiply with a[i - 1] and not with a[i] on purpose) and similarly suff[i] = suff[i + 1] * a[i + 1].
Now, at any index i our final answer ans[i] would be given by ans[i] = pre[i] * suff[i]. Why? Because the pre[i] * suff[i] contains product of every element before i and every element after i but not the element at index i (and that is the reson why we excluded a[i] in our prefix and suffix product).

The Time Complexity would be O(n), but we are now using Auxilary Space of O(n) (excluding the final answer array).

Below is the Java Code for this approach
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];

        for(int i=0; i<n; i++) {
            if(i==0) {
                prefixArr[i] = 1;
                suffixArr[n-1-i] = 1;
            } else {
                prefixArr[i] = prefixArr[i-1]*nums[i-1];
                suffixArr[n-1-i] = nums[n-i]*suffixArr[n-i];
            }
        }

        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = prefixArr[i]*suffixArr[i];
        }
        return answer;
    }
}

// Time: O(n)
// Space: O(n) Not optimized

/*
3. Directly store the product of prefix and suffix into the final answer array
The logic is, we don't actually need seperate array to store prefix product and suffix products, we can do all the approach discussed in method 3 directly onto our final answer array.

The Time Complexity would be O(n) but now, the Auxilary Space is O(1) (excluding the final answer array).

Below is the Java Code for the above algorithm.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer,1);
        int temp;
        int curr = 1;
        for(int i=0; i<n; i++) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i=n-1; i>=0; i--) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        return answer;
    }
}

// Time: O(n)
// Space: O(1)
