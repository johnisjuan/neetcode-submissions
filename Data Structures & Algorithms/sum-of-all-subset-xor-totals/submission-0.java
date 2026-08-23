class Solution {

    List<Integer> resList = new ArrayList<>();

    public int subsetXORSum(int[] nums) {

        List<Integer> subset = new ArrayList<>();
        backtrack(nums,subset,0);

        int res = 0;

        for(int x : resList){
            res = res + x;
        }
        return res;
    }

    private void backtrack(int[] nums,List<Integer> subset,int index){

        if(index >= nums.length){

            int temp = 0;

            for(int x : subset){
                temp = temp ^ x;
            }

            resList.add(temp);
            return;
        }

        subset.add(nums[index]);
        backtrack(nums,subset,index+1);
        subset.remove(subset.size() - 1);
        backtrack(nums,subset,index+1);
    }
}