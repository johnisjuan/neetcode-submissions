class Solution {
    public int findJudge(int n, int[][] trust) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        if(n == 1){
            return 1;
        }

        for(int i = 1;i<n+1;++i){
            map.put(i,0);
        }

        for(int[] arr : trust){
            int n1 = arr[0];
            int n2 = arr[1];
            int temp = map.get(n2);
            map.put(n2,temp+1);
            set.add(n1);
        }

        for(Map.Entry<Integer,Integer> x : map.entrySet()){
            if(x.getValue() == n-1 && !set.contains(x.getKey())){
                return x.getKey();
            }
        }

        return -1;
    }
}