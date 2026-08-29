class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int temp = currMax;

            currMax = Math.max(x, Math.max(x * currMax, x * currMin));
            currMin = Math.min(x, Math.min(x * temp, x * currMin));

            max = Math.max(max, currMax);
        }
        return max;
    }
} 
    