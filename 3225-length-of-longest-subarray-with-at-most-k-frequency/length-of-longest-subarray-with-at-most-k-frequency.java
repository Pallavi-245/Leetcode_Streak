import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int res = 0;

        for (int end = 0; end < n; end++) {

            // Increase frequency of nums[end]
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            // If frequency exceeds k, shrink the window
            while (map.get(nums[end]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);

                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }

                start++;
            }

            // Update maximum length
            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}