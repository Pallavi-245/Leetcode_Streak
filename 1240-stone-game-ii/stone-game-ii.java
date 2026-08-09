class Solution {
    int n;
        int dp[][][];
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp=new int[2][n+1][n+1];
        for(int[][] a:dp){
            for(int[] b: a){
            Arrays.fill(b,-1);
            }
        }
            return solve(1,0,1,piles);
        }
    
        public int solve(int per,int idx,int m,int[] p){
            if(idx>=n)
            return 0;
        
           if(dp[per][idx][m] !=-1){
            return dp[per][idx][m];
           } 
           int res=(per ==1) ? -1: Integer.MAX_VALUE;
           int stone=0;
           for(int x=1;x<=Math.min(2*m,n-idx);x++){
            stone +=p[idx+x-1];

            if(per==1){
                res=Math.max(res,stone +solve(0,idx+x,Math.max(x,m),p));
            }else{
                res=Math.min(res,solve(1,idx+x,Math.max(x,m),p));
            }
           }
           return dp[per][idx][m]=res;
        }
    }
