class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int[] cord : points){
            int d = cord[0]*cord[0] + cord[1]*cord[1];
            pq.offer(new int[]{d,cord[0],cord[1]});
        }

        int[][] res = new int[k][2];
        for(int i = 0;i<k;++i){
            int[] point = pq.poll();
            res[i] = new int[]{point[1],point[2]};
        }
        return res;
    }
}
