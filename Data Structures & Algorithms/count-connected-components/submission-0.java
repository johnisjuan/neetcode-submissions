class Solution {

    private Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    private HashSet<Integer> visited = new HashSet<>();
    private int res = 0;


    public int countComponents(int n, int[][] edges) {

        for(int i=0;i<n;++i){
            map.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i=0;i<n;++i){
            if(!visited.contains(i)){
                dfs(i);
                res++;
            }
        }

        return res;
    }

    private void dfs(int node){
        
        if(visited.contains(node)){
            return;
        }

        visited.add(node);

        for(int neighbour : map.get(node)){
            dfs(neighbour);
        }
    }
}
 