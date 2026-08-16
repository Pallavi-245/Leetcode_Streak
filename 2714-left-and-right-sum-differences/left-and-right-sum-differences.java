class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        int leftsum=0;
        int rightsum=totalsum;
        for(int i=0;i<n;i++){
            rightsum-=nums[i];

            ans[i]=Math.abs(leftsum-rightsum);
            leftsum+=nums[i];
        }
        return ans;
    }
}