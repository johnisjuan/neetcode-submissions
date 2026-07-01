class Solution {

    private HashSet<Integer> visiting = new HashSet<>();
    private HashMap<Integer,List<Integer>> list = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i=0;i<numCourses;++i){
            list.put(i,new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            list.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0;c<numCourses;++c){
            if(!dfs(c)){
                return false;
            }
        }
        return true;

        

    }

    private boolean dfs(int crs){

        if(visiting.contains(crs)){
            return false;
        }
        if(list.get(crs).isEmpty()){
            return true;
        }

        visiting.add(crs);
        for(int pre : list.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(crs);
        list.put(crs,new ArrayList<>());
        return true;
    }
}
