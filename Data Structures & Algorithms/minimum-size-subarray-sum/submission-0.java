class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int l = 0;
        int r = 0;
        int curSum = 0;
        int res = Integer.MAX_VALUE;

        while(r < nums.length){

            curSum += nums[r];

            while(curSum >= target){

                res = Math.min(res,r-l+1);
                    curSum -= nums[l];
                    l++;

            }
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}