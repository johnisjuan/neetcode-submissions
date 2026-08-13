record CharFreq(char ch,int freq){}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>(
            (x,y) -> Integer.compare(y.freq(),x.freq())
        );

        if (a >0) maxHeap.offer(new CharFreq('a',a));
        if (b > 0) maxHeap.offer(new CharFreq('b',b));
        if (c > 0) maxHeap.offer(new CharFreq('c',c));

        StringBuilder res = new StringBuilder();

        CharFreq prev = null;

        while(!maxHeap.isEmpty()){

            CharFreq cur = maxHeap.poll();
            int n = res.length();

            if( n >= 2 && 
            res.charAt(n-1) == cur.ch() &&
            res.charAt(n-2) == cur.ch()) {

                if(maxHeap.isEmpty()){
                    break;
                }

                CharFreq next = maxHeap.poll();

                res.append(next.ch());

                if(next.freq() -1 > 0){
                    maxHeap.offer(new CharFreq(next.ch(),next.freq()-1));
                }

                maxHeap.offer(cur);
            } else {
                res.append(cur.ch());

                if(cur.freq() -1 > 0){
                    maxHeap.offer(new CharFreq(cur.ch(),cur.freq()-1));
                }
            }

        }

        return res.toString();
    }
}