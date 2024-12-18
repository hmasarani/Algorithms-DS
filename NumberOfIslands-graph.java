class Solution {
    public int numIslands(char[][] grid) {
            int islands = 0;
        // loop through matrix: 
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    // explore
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int i, int j){
        // check boundaries
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
            return; 
        }
        grid[i][j] = '0';
        //explore all neighbors
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
