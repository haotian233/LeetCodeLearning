//动态规划，因为只存在f[n]与f[n-1]之间的关系，只需维护一数代替动态规划数组
int maxSubArray(vector<int>& nums) {
         int result = INT_MIN;
         int sum=0;
        for (int i = 0; i <nums.size(); i++)
        {
           sum+=nums[i];
           result=max(result,sum);
           if(sum<0) sum=0;
        }
        return result;
    }
    
/*分治：lSum 表示 [l, r][l,r] 内以 ll 为左端点的最大子段和
        rSum 表示 [l, r][l,r] 内以 rr 为右端点的最大子段和
        mSum 表示 [l, r][l,r] 内的最大子段和
        iSum 表示 [l, r][l,r] 的区间和
*/
    struct Status {
        int lSum, rSum, mSum, iSum;
    };

    Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = max(l.lSum, l.iSum + r.lSum);
        int rSum = max(r.rSum, r.iSum + l.rSum);
        int mSum = max(max(l.mSum, r.mSum), l.rSum + r.lSum);
        return (Status) {lSum, rSum, mSum, iSum};
    };

    Status get(vector<int> &a, int l, int r) {
        if (l == r) return (Status) {a[l], a[l], a[l], a[l]};
        int m = (l + r) >> 1;
        Status lSub = get(a, l, m);
        Status rSub = get(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    int maxSubArray(vector<int>& nums) {
        return get(nums, 0, nums.size() - 1).mSum;
    }
