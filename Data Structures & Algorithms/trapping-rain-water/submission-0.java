class Solution {

    public int trap(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int mleft = height[0];
        int mright = height[height.length-1];

        for(int i = 0;i<height.length;++i){
            mleft = Math.max(mleft,height[i]);
            maxLeft[i] = mleft;
        }

        for(int i = height.length-1;i >=0 ;--i){
            mright = Math.max(mright,height[i]);
            maxRight[i] = mright;
        }

        for(int i=0;i<height.length;++i){
            res += Math.min(maxLeft[i],maxRight[i]) - height[i];
        }


        return res;
    }
}
