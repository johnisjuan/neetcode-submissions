class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int totalWeight = 0;

        for(int weight : weights){
            totalWeight += weight;
        }

        int res = totalWeight;

        int l = Arrays.stream(weights).max().getAsInt();
        int r = totalWeight;

        while(l <= r){

            int m = l + (r-l)/2;

            int numberOfDays = helper(weights,m);

            if(numberOfDays <= days){
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }

        }
        return res;
    }

    private int helper(int[] weights,int m){

        int days = 1;
        int currw = 0;

        for(int weight : weights){
            if(currw + weight > m){
                days++;
                currw = 0;
            }
            currw += weight;
        }
        return days;
    }
}