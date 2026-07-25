class Solution {

    Set<String> op = Set.of("+","-","*","/");

    public int evalRPN(String[] tokens) {

     Deque<Integer> stack = new ArrayDeque<>();

     for(String s : tokens){

        if(op.contains(s)){

            int d2 = stack.pop();
            int d1 = stack.pop();

            if(s.equals("+")){
                stack.push(d1+d2);
            } else if(s.equals("-")){
                stack.push(d1-d2);
            } else if (s.equals("*")){
                stack.push(d1*d2);
            } else if (s.equals("/")){
                stack.push(d1/d2);
            }

        } else {
            int digit = Integer.parseInt(s);
            stack.push(digit);
        }

     }
        return stack.pop();
    }
}
