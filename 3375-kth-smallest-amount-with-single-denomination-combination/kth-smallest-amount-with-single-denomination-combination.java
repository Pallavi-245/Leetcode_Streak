class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        // 1 << n represents 2^n. We use bitmasking to iterate through all subsets.
        long[] lcm = new long[1 << n];
        int[] sign = new int[1 << n];
        
        // Precompute LCMs and inclusion-exclusion signs for all possible subsets
        for (int i = 1; i < (1 << n); i++) {
            long currentLcm = 1;
            int bits = 0;
            for (int j = 0; j < n; j++) {
                // If the j-th bit is set, include coins[j] in the subset
                if ((i & (1 << j)) != 0) {
                    currentLcm = lcm(currentLcm, coins[j]);
                    bits++;
                }
            }
            lcm[i] = currentLcm;
            // Odd number of elements = Add (+1), Even number = Subtract (-1)
            sign[i] = (bits % 2 == 1) ? 1 : -1;
        }
        
        // Binary search bounds
        long left = 1;
        long right = 50_000_000_000L; // Upper bound: max k * max coin = 2 * 10^9 * 25
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            // Count total unique valid amounts <= mid
            long count = 0;
            for (int i = 1; i < (1 << n); i++) {
                count += sign[i] * (mid / lcm[i]);
            }
            
            if (count >= k) {
                ans = mid;
                right = mid - 1; // Try to find an even smaller valid amount
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    // Helper method to find Greatest Common Divisor
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Helper method to find Least Common Multiple
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}