class Solution {
    public boolean search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length-1;

        while(l <= r){

            int m = (l + r)/2;

            if(nums[m] == target){
                return true;
            } 

            if(nums[l] == nums[m]
                && nums[r] == nums[m]){
                    l++;
                    r--;
                }

            else if(nums[l] <= nums[m]){
                if(target < nums[m]
                    && target >= nums[l]){
                        r = m-1;
                    } else {
                        l = m +1;
                    }
            } else {
                if(nums[r] >= target
                &&  nums[m] < target){
                    l = m +1;
                } else {
                    r = m -1;
                }
            }

        }

        return false;
    }
}