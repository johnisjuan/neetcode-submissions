class Solution {

    private static final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r=0;r<ROWS;++r){
            for(int c=0;c<COLS;++c){
                if(grid[r][c] == 0){
                    dfs(grid,r,c,0);
                }
            }
        }

    }

    private void dfs(int[][] grid,int r,int c,int count){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1){
            return;
        }

        if(count > 0 && grid[r][c] <= count){
            return;
        }

        grid[r][c] = count;
        count++;

        for(int[] cors : directions){
            dfs(grid,r+cors[0],c+cors[1],count);
        }

    }

}
