class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = -1;

        for(int i = 0 ;i<matrix.length;++i){
            if(matrix[i][matrix[0].length-1] >= target){
                row = i;
                break;
            }
        }

        if(row == -1){
            return false;
        }

        int l =0;
        int r = matrix[0].length-1;

        while(l <= r){
            int m = (l+r)/2;

            if(matrix[row][m] == target){
                return true;
            }
            else if(matrix[row][m] > target){
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return false;

    }
}
