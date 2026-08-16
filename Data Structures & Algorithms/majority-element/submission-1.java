class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums[0];
        int count = 1;

        for(int i = 1;i<nums.length;++i){
            if(nums[i] == n){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                n = nums[i];
                count = 1;
            }
        }

        return n;
    }
}