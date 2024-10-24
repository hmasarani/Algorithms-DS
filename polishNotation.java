class Solution {
    public int evalRPN(String[] tokens) {
        // Use a stack to store integer values
        Stack<Integer> stack = new Stack<>();

        // Loop through each token in the input array
        for (String token : tokens) {
            // If the token is a number, parse it to an integer and push to the stack
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                // If it's a number, parse and push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }
        // The final result is the last item left on the stack
        return stack.peek();
    }
}
