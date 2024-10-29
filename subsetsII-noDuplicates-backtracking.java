class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, res, curr, 0);

        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx){
        // append curr to res
        if(idx >= nums.length){
            res.add(new ArrayList<Integer>(curr)); 
            return;
        } 

        // we decide to add 
        curr.add(nums[idx]);
        dfs(nums, res, curr, idx+1);

        //pop
        curr.remove(curr.size() - 1);
        // if the numbers are the same, we call dfs and skip the number
        while(idx + 1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        dfs(nums, res, curr, idx+1);
    }

}
