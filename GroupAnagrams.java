class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert the string to a char array, sort it, and convert back to a string
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);

            // Add the original string to the list of anagrams in the map
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        // Convert the values to a list of lists
        res.addAll(map.values());
        return res;
    }
}
