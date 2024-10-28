class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();   // Step 1: Initialize a list to store all permutations
        List<Integer> curr = new ArrayList<>();        // Step 2: Initialize a list to store the current permutation being built
        boolean[] visited = new boolean[nums.length];  // Step 3: Track which elements have been used in the current permutation
        dfs(nums, res, curr, visited);                 // Step 4: Begin the DFS with the initial values
        return res;                                    // Step 5: Return the list of all permutations
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
        // Step 6: If the current permutation has reached the size of nums, we have a complete permutation
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr)); // Step 7: Add a copy of the current permutation to the results
            return;                         // Step 8: Return to explore other possibilities
        }

        // Step 9: Iterate over each number in nums to build permutations
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;       // Step 10: Skip numbers that have already been used in this permutation

            curr.add(nums[i]);              // Step 11: Choose the current number by adding it to curr
            visited[i] = true;              // Step 12: Mark the current number as visited

            dfs(nums, res, curr, visited);  // Step 13: Recursively call dfs to continue building the permutation

            // Step 14: Backtrack to explore other permutations
            curr.remove(curr.size() - 1);   // Remove the last added number from curr
            visited[i] = false;             // Unmark the current number as visited to make it available for future permutations
        }
    }
}
