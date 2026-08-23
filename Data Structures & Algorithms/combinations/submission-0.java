class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        
        
        backtrack(1,new ArrayList<Integer>(),k,n);
        

        return res;
    }

    private void backtrack(int index,List<Integer> subset,int k,int n){

        if(subset.size() == k){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(index > n){
            return;
        }

        subset.add(index);
        backtrack(index+1,subset,k,n);
        subset.remove(subset.size()-1);
        backtrack(index+1,subset,k,n);
    }
}