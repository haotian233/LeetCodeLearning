class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size()==0) return 0;
        int dp[nums.size()],maxvol=0;
        for(int i=0;i<nums.size();i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                dp[i]=max(dp[i],dp[j]+1);
            }
            maxvol=max(dp[i],maxvol);
        }
        return maxvol;
    }
};
