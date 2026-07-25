class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    int curMin = Integer.MAX_VALUE;

    public MinStack() {
        
        
    }
    
    public void push(int val) {
        stack.push(val);        
        curMin = Math.min(curMin,val);
        minStack.push(curMin);        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        curMin = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
