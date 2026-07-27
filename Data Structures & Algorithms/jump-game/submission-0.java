class Solution {
    public boolean canJump(int[] nums) {
        
        int farthest = 0;

        for(int i =0 ;i<nums.length;++i){

            if( i > farthest){
                return false;
            }

            int reachable = i + nums[i];

            farthest = Math.max(farthest,reachable);

        }
        return true;

    }
}
