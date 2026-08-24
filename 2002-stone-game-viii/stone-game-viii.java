class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Calculate total sum
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        // dp for the last possible move
        int ans = sum;

        // Move backwards
        for (int i = n - 2; i >= 1; i--) {
            sum -= stones[i + 1];

            ans = Math.max(ans, sum - ans);
        }

        return ans;
    }
}