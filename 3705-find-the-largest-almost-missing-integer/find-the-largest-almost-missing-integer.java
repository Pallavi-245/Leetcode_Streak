class Solution {
    public int largestInteger(int[] nums, int k) {
        int res=-1;
        int len=nums.length;
        if(len==k){
            res=nums[0];
            for(int x:nums){
                res=Math.max(res,x);
            }
            return res;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        if(k==1){
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(entry.getValue()==1){
                    res=Math.max(res,entry.getKey());
                }
            }
            return res;
        }
        if(map.get(nums[0])==1){
        res = Math.max(res, nums[0]);
        }
        if (map.get(nums[len - 1]) == 1) {
            res = Math.max(res, nums[len - 1]);
        }

        return res;
    }
}