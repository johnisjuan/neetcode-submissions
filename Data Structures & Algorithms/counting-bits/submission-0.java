class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];

        for(int i =0;i<n+1;++i){
            int num = i;

            int tempRes = 0;

            while(num != 0){
                int digit = num & 1;
                if(digit == 1){
                    tempRes++;
                }
                num >>>= 1;
            }
            res[i] = tempRes;
        }  

        return res;
    }
}
