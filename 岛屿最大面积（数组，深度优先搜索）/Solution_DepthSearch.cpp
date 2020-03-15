class Solution {
public:
    int m=0,area=0;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]==1)
                find(i,j,grid);
                area=max(m,area);//更新最大的岛屿面积
                m=0;//更新m的值为0
            }
        }
        return area;
    }
    int find(int x,int y,vector<vector<int>>& grid){
        if(grid[x][y]==1){
            grid[x][y]=0;//将搜索完的部分置零，防止重复搜索
            m++;
            if(x<grid.size()-1)
            find(x+1,y,grid);
            if(x>0)
            find(x-1,y,grid);
            if(y>0)
            find(x,y-1,grid);
            if(y<grid[0].size()-1)
            find(x,y+1,grid);
        }
        return m;
    }
};
