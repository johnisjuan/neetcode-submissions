class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        visit = new boolean[nums.length];

        Arrays.sort(nums);
        List<Integer> perm = new ArrayList<>();
        dfs(nums,perm);
        return res;
    }

    private void dfs(int[] nums,List<Integer> perm){

        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0;i<nums.length;++i){
            if(visit[i] || (i > 0 && nums[i] == nums[i-1]) && !visit[i-1]){
                continue;
            }

            visit[i] = true;
            perm.add(nums[i]);
            dfs(nums,perm);
            visit[i] = false;
            perm.remove(perm.size()-1);

        }

    }
}