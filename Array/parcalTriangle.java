class Solution {
    public List<List<Integer>> generate(int count) {
        List<List<Integer>> arr = new ArrayList<>();

        arr.add(new ArrayList<Integer>(){{add(1);}});

        if (count == 1) {
            return arr;
        }

        arr.add(new ArrayList<Integer>(){{add(1); add(1);}});

        if (count == 2) {
            return arr;
        }

        for (int i = 2; i < count; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j)); 
            }
            temp.add(1);
            
            arr.add(temp);
        }
        return arr;
    }
}
