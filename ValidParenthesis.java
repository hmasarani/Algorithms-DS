class Solution {
    public boolean isValid(String s) {
        //Using Stack --> LIFO
        //Using PQ.   --> FIFO

        Stack<Character> st = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(c=='('){
                st.push(')');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(c=='{'){
                st.push('}');
            }
            else{
                if(st.empty() == true){
                    return false;
                }
                else if(c!=st.peek()){
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
}
