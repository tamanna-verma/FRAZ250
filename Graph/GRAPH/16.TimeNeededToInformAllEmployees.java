class Pair{
    int node;
    int time;
    Pair(int node, int time){
        this.node = node;
        this.time=time;
    }
}
class Solution {
    int ans = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Pair>());
        }
        for(int i=0;i<manager.length;i++){
         if(manager[i]!=-1) graph.get(manager[i]).add(new Pair(i , informTime[i]));
        }
           int curr=0;
           dfs(graph , headID ,informTime[headID]);
           return ans;
    }
    public  void dfs(ArrayList<ArrayList<Pair>> graph , int manager , int curr){
        if(curr>ans)ans=curr;
     
        int size = graph.get(manager).size();
        for(int i=0;i<size;i++){
           Pair mgr = graph.get(manager).get(i);
           int node = mgr.node;
           int time = mgr.time;
           dfs(graph,node,curr+time);
        }
    }
    
}

//manager - bfs
