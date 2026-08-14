class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> Integer.compare(a[a.length - 1], b[b.length - 1]));

        int n = trips[trips.length-1][2];

        int[] arr = new int[n+1];

        for(int[] trip : trips){

            int number = trip[0];
            int start = trip[1];
            int end = trip[2];

            for(int i = start;i<end; ++i){
                arr[i]  = arr[i] + number;
            }

        }

        for(int i = 0;i<n;++i){
            if(arr[i] > capacity){
                return false;
            }
        }

        return true;
    }
}