class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(res, curr, nums, target, 0, 0);
        return res; 
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int target, int total, int idx) {
        // Base case: If we reach the target, add a copy of the current combination
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // If we exceed the target or go out of bounds, return
        if (total > target || idx >= nums.length) {
            return;
        }

        // Option 1: Include nums[idx] in the combination
        curr.add(nums[idx]);
        dfs(res, curr, nums, target, total + nums[idx], idx); // Call dfs with updated total, keeping idx the same
        curr.remove(curr.size() - 1); // Backtrack

        // Option 2: Skip nums[idx] and move to the next index
        dfs(res, curr, nums, target, total, idx + 1);
    }
}
