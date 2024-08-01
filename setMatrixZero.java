class Solution {
    public void setZeroes(int[][] arr) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }

        for (int i : r) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i : c) {
            for (int j = 0; j < row; j++) {
                arr[j][i] = 0;
            }
        }
    }
}
