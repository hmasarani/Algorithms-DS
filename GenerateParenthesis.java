class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    public void backtrack(List<String> output, String currentString, int open, int close, int max){
        // BASE CASE that abides by contraints: new string after exhaustion
        if(currentString.length() == max * 2){
            output.add(currentString);
            return;
        }
        
        // RECURSION
        if(open<max) backtrack(output, currentString + "(", open+1, close, max);
        if(close<open) backtrack(output, currentString + ")", open, close+1, max);   
    }
}
