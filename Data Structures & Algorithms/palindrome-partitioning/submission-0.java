class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        dfs(0,s);
        return res;
    }

    private void dfs(int i, String s){
        
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        
        for(int j = i;j<s.length();++j){
            if(isPal(s,i,j)){
                part.add(s.substring(i,j+1));
                dfs(j+1,s);
                part.remove(part.size()-1);
            }
        }



    }

    private boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
