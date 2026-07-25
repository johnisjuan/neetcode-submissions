class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for(int x : nums){
            add(x);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
