class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        HashSet<List<Integer>> pac = new HashSet<>();
        HashSet<List<Integer>> atl = new HashSet<>();

        for(int i=0;i<heights[0].length;++i){
            dfs(0,i,pac,heights);
        }

        for(int i=0;i<heights.length;++i){
            dfs(i,0,pac,heights);
        }

        for(int i=0;i<heights.length;++i){
            dfs(i,heights[0].length-1,atl,heights);
        }

        for(int i=0;i<heights[0].length;++i){
            dfs(heights.length-1,i,atl,heights);
        }

        for(List<Integer> coord : pac){
            if(atl.contains(coord)){
                res.add(coord);
            }
        }

        return res;
    }

    private void dfs(int row,int col,HashSet<List<Integer>> ocean,int[][] heights){
        
        List<Integer> currentCoord = List.of(row,col);

        if(!ocean.add(currentCoord)){
            return;
        }


        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length){
                if (heights[newRow][newCol] >= heights[row][col]) {
                    dfs(newRow, newCol, ocean, heights);
                }
            }
        }

    }
}