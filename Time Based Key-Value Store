class TimeMap {
    // we will be using treeMap to maintain the ordering 
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap());
        }
            TreeMap<Integer, String> timemap = map.get(key);
            timemap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
                TreeMap<Integer, String> treemap = map.get(key);
                Integer prev = treemap.floorKey(timestamp);
            if(prev == null){
                return "";
            }
            return treemap.get(prev); 
    }
}
