class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();

        for(int x : asteroids){

            if(x > 0){
                stack.push(x);
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(x)){
                stack.pop();
            }

            if(!stack.isEmpty() &&  stack.peek() == Math.abs(x)){
                stack.pop();
            } else if(stack.isEmpty() || stack.peek() < 0){
                stack.push(x);
            }

        }

        int[] res = new int[stack.size()];

        int i = res.length - 1;

        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}