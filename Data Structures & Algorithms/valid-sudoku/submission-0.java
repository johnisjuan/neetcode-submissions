class Solution {

    Map<Integer,ArrayList<Integer>> row = new HashMap<>();
    Map<Integer,ArrayList<Integer>> col = new HashMap<>();
    Map<Integer,ArrayList<Integer>> square = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;++i){
            row.put(i,new ArrayList<>());
            col.put(i,new ArrayList<>());
            square.put(i,new ArrayList<>());
        }

        for(int i = 0;i<9;++i){
            for(int j = 0;j<9;++j){

                if(board[i][j] == '.'){
                    continue;
                }

                int val = board[i][j] - '0';

                int squareVal = (i/3) * 3 + (j/3);

                if(row.get(i).contains(val)){
                    return false;
                }
                if(col.get(j).contains(val)){
                    return false;
                }
                if(square.get(squareVal).contains(val)){
                    return false;
                }

                row.get(i).add(val);
                col.get(j).add(val);
                square.get(squareVal).add(val);
            }
        }
        return true;
    }
}
