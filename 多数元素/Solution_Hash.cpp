class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majority=0, cnt=0;
        unordered_map <int,int> counter;
        for(int i=0;i<nums.size();i++){
            counter[nums[i]]++;
            if(counter[nums[i]]>cnt){
                majority=nums[i];
                cnt=counter[nums[i]];
            }
        }
        if(cnt>nums.size()/2)
        return majority;
        else return 0;
    }
};
