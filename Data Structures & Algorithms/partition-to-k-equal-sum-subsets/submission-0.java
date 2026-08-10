class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
    
     int totalSum = Arrays.stream(nums).sum();
     int target = totalSum / k;

     if(totalSum % k != 0){
        return false;
     }

     boolean[] used = new boolean[nums.length];
     Arrays.fill(used,false);
     
     Arrays.sort(nums);
     reverse(nums);

     return dfs(nums,k,used,target,0);
    }

    private void reverse(int[] nums){
        for(int i = 0,j=nums.length-1;i<j;++i,--j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    private boolean dfs(int[] nums,int k,boolean[] used,int target,int subsetSum){

        if(k == 0){
            return true;
        }
        
        if(subsetSum == target){
            return dfs(nums,k-1,used,target,0);
        }

        for(int i = 0;i<nums.length;++i){

            if(used[i] || subsetSum + nums[i] > target){
                continue;
            }
            used[i] = true;
            if(dfs(nums,k,used,target,subsetSum + nums[i])){
                return true;
            }
            used[i] = false;
            if(subsetSum == 0){
                return false;
            }
        }
        return false;
    }
}
