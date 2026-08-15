class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // If all elements are 0, every subsequence has XOR = 0
        if (!hasNonZero) {
            return 0;
        }

        // If the XOR of the entire array is non-zero, take all elements
        if (totalXor != 0) {
            return nums.length;
        }

        // If total XOR is 0, removing any non-zero element x gives XOR = 0 ^ x = x != 0
        return nums.length - 1;
    }
}