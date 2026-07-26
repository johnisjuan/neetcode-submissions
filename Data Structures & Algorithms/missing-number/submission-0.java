class Solution {
    public int missingNumber(int[] nums) {
        
        int pass1 = 0;

        for(int num : nums){
            pass1 = pass1 ^ num;
        }

        int pass2 = 0;

        for(int i = 0;i<nums.length+1;++i){
            pass2 = pass2 ^ i;
        }   
        return pass1 ^ pass2;
    }
}
