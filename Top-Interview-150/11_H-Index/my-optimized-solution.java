/*
Approach: 1 Sorting and Iteration
Sorting: Sorts the citations list in ascending order.
Iterative Check: Iterates through the sorted list.
For each citation v at index i:
If n - i (number of articles with at least n - i citations) is less than or equal to v itself (the current citation count), it means the h-index is n - i.
Returns n - i as the h-index.
Default Return: If no valid h-index is found, returns 0.
Code : 1
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations.sort()

        for i,v in enumerate(citations):
            if n - i <= v:
                return n - i
        return 0
Approach: 2 Counting Frequency and Backward Iteration
Frequency Array: Creates a temporary array temp of size n + 1 to store citation frequencies.
Counting Citations: Iterates through the citations list:
If a citation v is greater than n, adds it to the highest frequency bucket (temp[n]).
Otherwise, increments the count in the corresponding bucket (temp[v]).
Calculating h-index: Iterates backward through the temp array:
Accumulates the total number of citations up to each index i.
If the total count (total) is greater than or equal to i itself, it means i is the h-index.
Returns i as the h-index.
Code : 2
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        temp = [0 for _ in range(n + 1)]

        for i,v in enumerate(citations):
            if v > n :
                temp[n] += 1
            else:
                temp[v] += 1
        
        total = 0
        for i in range(n, -1, -1):
            total += temp[i]
            if total >= i:
                return i
Comparison Table:
Feature	Code 1	Code 2
Approach	Sorting and iteration Frequency	counting and backward iteration
Time Complexity	O(n log n) due to sorting	O(n)
Space Complexity	O(1)	O(n) for temp array
Advantages	Simpler to understand	Linear time complexity
Disadvantages	Slower for large inputs	Requires extra space for temp array

*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int hIdx = 0;
        int hIdxArr[] = new int[n+1];
        for(int i=0;i<n;i++) {
            if(citations[i]>=n) {
                hIdxArr[n]++;
            } else {
                hIdxArr[citations[i]]++;
            }
        }
        int sum=0;
        for(int i=n; i>=0; i--) {
            if(hIdxArr[i]+sum >= i) {
                return i;
            } else {
                sum = sum+hIdxArr[i];
            }
        }
        return hIdx;
    }
}


// Time: O(n) 
// Space: O(n)

// With sorting technique, time:O(nlogn), space:O(1)
