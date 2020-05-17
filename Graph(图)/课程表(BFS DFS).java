//BFS广度优先搜索
public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];//入度的数组
        Queue<Integer> queue = new LinkedList<Integer>();//队列，保存入度为0的节点
        List<List<Integer>> adjacency = new ArrayList<>();//保存节点是是谁的前置节点，如果节点出队，则所有后置节点入度减一
        int[] order=new int[numCourses];//结果
        int flag = 0;
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList());//初始化
        }
        for(int[] cur:prerequisites){
            indegrees[cur[0]]++;//统计各个节点的入度
            adjacency.get(cur[1]).add(cur[0]);//统计我是谁的前置课程
        }
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) queue.offer(i);//将入度为0加入队列
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();
            order[flag++] = pre ;
            numCourses--;//是否所有节点都被遍历
           for(int cur : adjacency.get(pre))//选取当前节点是谁的前置节点
                if(--indegrees[cur] == 0) queue.add(cur);//将节点入度减一
        }
        if(numCourses!=0) return new int[0];
        return order;
    }
