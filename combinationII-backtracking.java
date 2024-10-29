class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        dfs(candidates, target, 0, res, curr, 0); // Start DFS
        return res;
    }

    public void dfs(int[] candidates, int target, int total, List<List<Integer>> res, List<Integer> curr, int idx) {
        // Base case: if total matches target
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Exit if total exceeds target or we reach end of array
        if (total > target || idx >= candidates.length) {
            return;
        }

        // Loop through each candidate starting from idx
        for (int i = idx; i < candidates.length; i++) {
            // Skip duplicates after the first instance
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // Include candidates[i] in the combination
            curr.add(candidates[i]);
            dfs(candidates, target, total + candidates[i], res, curr, i + 1); // Move to next index

            // Backtrack by removing last element added
            curr.remove(curr.size() - 1);
        }
    }
}
