class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        //loop through grid: 
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    //we backtrack
                    if(backtrack(board, word, i, j, 0)){
                        return true;
                    }
             
                }
            }
        }
    return false; 
    }
    public boolean backtrack(char[][] board, String word, int i, int j, int idx){
        if(word.length() == idx) return true;
        // eliminate characters
        if(i < 0 || j < 0 || i>=board.length || j>=board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)) return false; 
        //check all directions! 
        visited[i][j] = true;
        if(
            backtrack(board, word, i, j+1, idx+1) ||
            backtrack(board, word, i, j-1, idx+1) ||
            backtrack(board, word, i+1, j, idx+1) ||
            backtrack(board, word, i-1, j, idx+1)
        ){
            return true; 
        }
        visited[i][j] = false; 
        return false;
    }
}
