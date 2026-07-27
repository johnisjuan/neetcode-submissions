class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        int curSum = 0;

        for(int num : nums){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += num;
            res = Math.max(res,curSum);
        }

        return res;
    }
}
