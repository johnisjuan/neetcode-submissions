class Solution {

    HashSet<Integer> visited = new HashSet<>();
    Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){
            return false;
        }

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0,-1)){
            return false;
        }

        return visited.size() == n;

    }

    private boolean dfs(int node,int parent){

        if(visited.contains(node)){
            return false;
        }

        visited.add(node);

        for(int x : graph.get(node)){

            if(x == parent){
                continue;
            }

            if(!dfs(x,node)){
                return false;
            }
        }
        return true;
    }
}
