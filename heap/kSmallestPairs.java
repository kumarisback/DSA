class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Pair<Integer,Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        minHeap.offer( new int[]{nums1[0]+nums2[0], 0 , 0});

        int l1 = nums1.length;
        int l2 = nums2.length;


        while( k-- > 0 && !minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            result.add(List.of(nums1[i],nums2[j]));

            if( i + 1 < l1 && !visited.contains(new Pair<Integer, Integer>(i + 1, j))){
                minHeap.offer(new int[]{ nums1[i+1] + nums2[j], i+1, j });
                visited.add(new Pair<Integer,Integer>(i+1, j));
            }
            if( j + 1 < l2 && !visited.contains(new Pair<Integer, Integer>(i, j+1))){
                minHeap.offer(new int[]{ nums1[i] + nums2[j+1], i, j+1 });
                visited.add(new Pair<Integer,Integer>(i, j+1));
            }
        }
        return result;
    }
}
