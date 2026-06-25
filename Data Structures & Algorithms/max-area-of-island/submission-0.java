class Solution {

    int res = 0;
    int count = 0;

    private static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int i=0;i<ROWS;++i){
            for(int j=0;j<COLS;++j){
                if(grid[i][j] == 1){
                    count = 0;
                    dfs(grid,i,j,ROWS,COLS);
                    res = Math.max(res,count);
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid,int r,int c,int ROWS,int COLS){
        if(r >= ROWS || r < 0 || c >= COLS || c < 0 || grid[r][c] == 0){
            return;
        }

        grid[r][c] = 0;
        count++;

        for(int[] cor : directions){
            dfs(grid,r+cor[0],c+cor[1],ROWS,COLS);
        }

    }
}
