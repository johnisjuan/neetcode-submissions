class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("",n,0,0);
        return res;
    }

    private void dfs(String current, int n,int open,int close){

        if(n == 0 && open == close){
            res.add(current);
            return;
        }

        if(n < 0 || close > open){
            return;
        }

        dfs(current + "(",n-1,open+1,close);
        dfs(current + ")",n,open,close+1);

    }
}
