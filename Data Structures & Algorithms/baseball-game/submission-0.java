class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String c : operations) {

            if (c.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.peek();

                stack.push(n1);        // restore the latest score
                stack.push(n1 + n2);   // add the new score

            } else if (c.equals("D")) {
                stack.push(stack.peek() * 2);

            } else if (c.equals("C")) {
                stack.pop();

            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}