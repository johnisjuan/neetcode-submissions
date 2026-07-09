class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
        large = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        small.add(num);

        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }

        if (large.size() > small.size()) {
            return large.peek();
        }

        return ((long) small.peek() + (long) large.peek()) / 2.0;
    }
}