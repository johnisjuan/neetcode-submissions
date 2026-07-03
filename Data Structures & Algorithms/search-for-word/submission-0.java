class Solution {

    private static final int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int r,int c,String word,int wordSize){
        
        if(wordSize == word.length()){
            return true;
        }

        if(r >= board.length || r < 0 || c >= board[0].length || c < 0){
            return false;
        }

        if(board[r][c] != word.charAt(wordSize)){
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        
        for(int[] dir : direction){
            int nrow = r + dir[0];
            int ncol = c + dir[1];

            if(dfs(board,nrow,ncol,word,wordSize+1)){
                board[r][c] = temp;
                return true;
            }
        }
        board[r][c] = temp;

        return false;
    }
}
