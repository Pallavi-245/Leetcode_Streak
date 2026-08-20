import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
        // Base case: if the array has 2 or fewer elements, it's already in its final state
        if (nums.length <= 2) {
            return nums;
        }

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Step 1 & 2: Initialize the arrays with the first two elements
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Step 3: Iterate through the rest of the elements
        for (int i = 2; i < nums.length; i++) {
            // Compare the last elements of arr1 and arr2
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Concatenate the two lists into the final result array
        int[] result = new int[nums.length];
        int index = 0;
        
        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }

        return result;
    }
}