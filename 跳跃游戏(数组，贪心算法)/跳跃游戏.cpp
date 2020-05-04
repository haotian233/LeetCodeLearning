//第一次自己的想法，但会超出时间限制
bool jump(vector<int>& nums,int start){
        int i;
        if(start == nums.size()-1)
            return true;
        for(i = 1;i<=nums[start];i++){
            if(jump(nums,i+start))
                return true;
        }
        return false;
    }
    bool canJump(vector<int>& nums) {
        return jump(nums,0);
}
//改进后的写法
//1.如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
//2.可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
//3.如果可以一直跳到最后，就成功了。
bool canJump(vector<int>& nums) 
{
	int k = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		if (i > k) return false;
		k = max(k, i + nums[i]);
	}
	return true;
}
