class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Array to store the minimum value from index i to n-1
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        
        // Precompute suffix minimums going backwards
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }
        
        int prefMax = nums[0];
        
        // Iterate to find the first index that satisfies the condition
        for (int i = 0; i < n; i++) {
            prefMax = Math.max(prefMax, nums[i]);
            
            // Instability score is max(nums[0..i]) - min(nums[i..n-1])
            if (prefMax - suffMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}