//用dp(i) 来表示从第 ii 天开始到一年的结束，我们需要花的钱
/*
我们是倒着进行动态规划的，因此我们可以使用记忆化搜索，减少代码的编写难度。我们使用一个长度为 366 的数组
（因为天数是[1,365]，而数组的下标是从 0 开始的）存储所有的动态规划结果，
这样所有的 \textit{dp}(i)dp(i) 只会被计算一次（和普通的动态规划相同），时间复杂度不会增大
*/
class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) {
            dayset.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (dayset.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        }
        else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }
}

/*
观察方法一的递推式，我们可以看到，如果我们查询 \textit{dp}(i)dp(i)，而第 ii 天我们又不需要出行的话，
那么dp 函数会一直向后计算dp(i+1)=dp(i+2)=dp(i+3) 一直到一年结束或者有一天我们需要出行为止。
那么我们其实可以直接跳过这些不需要出行的日期，直接找到下一个需要出行的日期
*/
class Solution {
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }
}
