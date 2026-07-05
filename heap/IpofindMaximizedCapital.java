class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int l = profits.length;
        int[][] p = new int[l][2];

        for(int i =0; i < l;i++){
            p[i][0]= capital[i];
            p[i][1]= profits[i];
        }

        Arrays.sort(p ,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int  i = 0;
        while( k-- > 0){
            while( i < l && p[i][0] <= w){
                pq.add(p[i][1]);
                i++;
            } 
            if(pq.isEmpty()) break;

            w += pq.poll();
        }
    return w;

    }
}
