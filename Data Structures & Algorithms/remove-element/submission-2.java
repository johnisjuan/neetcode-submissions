class Solution {
    public int removeElement(int[] nums, int val) {
        
        int n = nums.length;
        int totalCount = 0;

        for(int num : nums){
            if(num == val){
                totalCount++;
            }
        }

        int l = 0;
        int r = nums.length-1;

        while(l < r){

            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;

            while(nums[r] == val && r > 0){
                r--;
            }

            while(l < n && nums[l] != val){
                l++;
            }
        }

        return n - totalCount;
    }
}