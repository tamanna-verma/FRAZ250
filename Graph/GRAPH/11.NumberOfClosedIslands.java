class Solution {
    public int closedIsland(int[][] grid) {
         // we will do the boundary dfs and make all 0 connected to boundary as 1 and all o's connected to those zeroes as ones 
          int n = grid.length;
          int m = grid[0].length;
          for(int i=0;i<n;i++){
              for(int j=0;j<m;j++){
                  if(i*j==0 || i==n-1 || j==m-1)
                  if(grid[i][j]==0) dfs(i , j ,n , m , grid);
              }
          }
          int ans=0;
          for(int i=0;i<n;i++){
              for(int j=0;j<m;j++){
                  
                  if(grid[i][j]==0) 
                  { ans++;
                      dfs(i , j ,n , m , grid);
                  }
              }
          }
          return ans;

    }
    public static void  dfs (int i , int j , int n , int m , int[][]grid){
         if(grid[i][j]==0)grid[i][j]=1;
         int dx[]={0,0,+1,-1};
         int dy[]={+1,-1,0,0};

         for(int k=0;k<4;k++){
             int x = i+dx[k];
             int y = j+dy[k];
             if(x<n && x>=0 && y>=0 && y<m && grid[x][y]==0)dfs(x , y , n , m , grid);
         }
    }

}
