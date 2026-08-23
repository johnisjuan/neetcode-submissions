class FreqStack {

    Map<Integer,Integer> count;
    Map<Integer,Stack<Integer>> stack;
    int maxFreq;

    public FreqStack() {
        
        count = new HashMap<>();
        stack = new HashMap<>();
        maxFreq = 0;

    }
    
    public void push(int val) {
        
        int valCount = count.getOrDefault(val,0) + 1;
        count.put(val,valCount);
        if(valCount > maxFreq){
            maxFreq = valCount;
            stack.putIfAbsent(valCount,new Stack<>());
        }
        stack.get(valCount).push(val);

    }
    
    public int pop() {
        
        int res = stack.get(maxFreq).pop();
        count.put(res,count.get(res) - 1);
        if(stack.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */