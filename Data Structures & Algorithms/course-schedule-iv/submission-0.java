class Solution {

    HashMap<Integer,List<Integer>> map;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        map = new HashMap<>();

        for(int i = 0;i<numCourses;++i){
            map.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int n1 = pre[0];
            int n2 = pre[1];   
            map.get(n2).add(n1);
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] q : queries){
            
            int n1 = q[1];
            int n2 = q[0];
            HashSet<Integer> path = new HashSet<>();

            boolean b = dfs(path,n1,n2);
            res.add(b);
        }

        return res;
    }

    private boolean dfs(HashSet<Integer> path,int cur,int target){

        if(path.contains(cur)){
            return false;
        }

        if(cur == target){
            return true;
        }

        path.add(cur);

        List<Integer> node = map.get(cur);

        for(int x : node){
            if(dfs(path,x,target)){
                return true;
            }
        }
        return false;
    }
}