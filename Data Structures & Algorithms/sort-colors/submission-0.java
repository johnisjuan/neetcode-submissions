class Solution {
    public void sortColors(int[] nums) {
        int[] temp = new int[3];

        for(int num : nums){
            temp[num]++;
        }

        int i = 0;

        for(int j = 0;j<3;++j){
            for(int k = 0;k<temp[j];++k){
                nums[i] = j;
                i++;
            }
        }
    }
}