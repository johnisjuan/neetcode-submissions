class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int x : stones){
            pq.offer(x);
        }

        while(pq.size() > 1){

            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2){
                continue;
            } else if (s1 > s2){
                pq.offer(s1-s2);
            } else {
                pq.offer(s2-s1);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
