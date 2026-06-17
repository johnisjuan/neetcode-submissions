class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> s = new HashMap<>();

        for(int i=0;i<nums.length;++i){
            int res = target - nums[i];
            if(s.containsKey(res)) return new int[]{s.get(res),i};
            s.put(nums[i],i);

        }
        return new int[]{};
    }
}
