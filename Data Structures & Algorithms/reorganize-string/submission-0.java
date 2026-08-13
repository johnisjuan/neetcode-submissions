record CharFreq(char ch,int freq){}

class Solution {
    public String reorganizeString(String s) {

        StringBuilder res = new StringBuilder();
        
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        PriorityQueue<CharFreq> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.freq(),a.freq())
        );

        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()) {
            pq.offer(
                new CharFreq(entry.getKey(),entry.getValue())
            );
        }

        CharFreq prev = null;

        while(!pq.isEmpty()){

            CharFreq cur = pq.poll();

            res.append(cur.ch());
            
            int newFreq = cur.freq() - 1;

            if(prev != null && prev.freq() > 0){
                pq.offer(prev);
            }

            prev = new CharFreq(cur.ch(),newFreq);
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}