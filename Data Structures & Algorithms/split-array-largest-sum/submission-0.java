class Solution {

    public int splitArray(int[] nums, int k) {
        
        int r = 0;
        int l = -1;

        for(int num : nums){
            r += num;
            l = Math.max(l,num);
        }

        while(l <= r){

            int m = l + (r-l)/2;

            boolean check = checkArray(nums,m,k);

            if (check == true){
                r = m-1;
            } else {
                l = m + 1;
            }
            
        }
        return l;
    }

    private boolean checkArray(int[] nums,int maxSum,int maxArray){

        int count = 1;
        int curSum = 0;

        for(int num : nums){
            
            if(curSum + num > maxSum){
                count++;
                curSum = 0;
            }
            curSum += num;
        }

        return count <= maxArray;
    }
}   