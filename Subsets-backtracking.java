class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(nums, res, curr, 0);
        return res; 
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx){
        // step 1 is to append the list: 
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // add: 
        curr.add(nums[idx]);
        dfs(nums, res, curr, idx+1);
        //not add
        curr.remove(curr.size() - 1);
        dfs(nums, res, curr, idx+1);
    }
}
