class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {


        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int idx = i * n + j;
                int newIdx = (idx + k) % total;

                ans[newIdx / n][newIdx % n] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int[] row : ans) {
            List<Integer> list = new ArrayList<>();
            for (int val : row)
                list.add(val);
            res.add(list);
        }

        return res;



        // List<List<Integer>> result = new ArrayList<>();

        // int m = grid.length;
        // int n = grid[0].length;
        // int last = Integer.MAX_VALUE;
        // while(k-- > 0){
        // for(int i = m-1 ; i >= 0 ; i--){
        //     for(int j = n-1; j >= 0 ; j--){
        //         if( i == m-1 && j == n-1 ){
        //             last = grid[i][j];
        //         }
        //         if(j-1 >= 0){
        //             grid[i][j] = grid[i][j-1];
        //         }
        //         else if(i-1 >= 0){
        //             grid[i][j] = grid[i-1][n-1];
        //         }else if(last != Integer.MAX_VALUE){
        //             grid[i][j] = last;
        //         }
        //     }
        // }}


        // for(int i = 0 ; i < m ; i++){
        //     List<Integer> temp = new ArrayList<>();
        //     for(int j = 0; j < n; j++){
        //         temp.add(grid[i][j]);
        //     }
        //     result.add(temp);
        // }
        // return result;
    }
}
