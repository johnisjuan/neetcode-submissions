class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }

        int maxpos = 1;
        int maxneg = 1;
        int res = nums[0];
        
        for(int i=0;i<nums.length;++i){

            int val = nums[i];
            int temp = maxpos * val;

            maxpos = Math.max(val,Math.max(val*maxpos,val*maxneg));
            maxneg = Math.min(val,Math.min(temp,val*maxneg));

            res = Math.max(res,maxpos);
            

        }


        
        return res;

    }
}
