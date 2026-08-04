class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        
        int l = 0;
        int r = n - 1;

        while(r-l >= k){

            if(Math.abs(arr[r] - x) >= Math.abs(arr[l] - x)){
                r--;
            } else {
                l++;
            }

        }
        
        for(int i = l;i<=r;++i){
            res.add(arr[i]);
        }
        return res;
    }
}