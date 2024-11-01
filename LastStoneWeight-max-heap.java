class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> des = new ArrayList<Integer>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());
        // we add all elements to pq. 
        for(int i : stones){
            minheap.offer(i);
        }
        while(minheap.size() > 1){
            //after each iteration -- reduce size by 1
            int el1 = minheap.poll();
            int el2 = minheap.poll();
                
            int res = el1 - el2;
            if(res != 0) minheap.offer(res);
        }

        return minheap.isEmpty()? 0 : minheap.peek();
    }

}
