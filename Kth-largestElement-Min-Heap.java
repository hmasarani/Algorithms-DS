class KthLargest {
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for( int i : nums){
            minheap.offer(i);
        }
        while(minheap.size()>k){
            minheap.poll();
        }

    }
    
    public int add(int val) {
        minheap.add(val);
        while(minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}
