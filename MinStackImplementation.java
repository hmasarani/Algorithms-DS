class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;
    public MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        //if the value is smaller, add to minstack otherwise add peek()

        if(!minStack.empty()){
            if(val< minStack.peek()){
                minStack.push(val);
            }
            else{
                minStack.push(minStack.peek());
            }
        }
        else{
            minStack.push(val);
        }
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
