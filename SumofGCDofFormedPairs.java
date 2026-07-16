class Solution {
    Map<String,Integer> gcdCache = new HashMap<>();
    public long gcdSum(int[] nums) {
        int l = nums.length;
        int[] prefixGcd = new int[l];
        int[] mx = new int[l];

        for(int i = 0 ; i < l; i++){
            if(i == 0) {
                mx[i] = nums[i];
                prefixGcd[i] = nums[i];
                continue;
            }
            mx[i] = Math.max(mx[i-1], nums[i]);
            prefixGcd[i] = gcd(mx[i], nums[i]);
        }

        int  left = 0;
        int  right = l-1;
        long sum = 0;
        Arrays.sort(prefixGcd);
        while( left < right ){
            sum+= gcd(prefixGcd[left],prefixGcd[right]);
            System.out.println(sum+"==");
            left++;
            right--;
        }
        return sum;
    }

    public int gcd(int a, int b){
        String key = a+"-"+b;
        if(gcdCache.containsKey(key)) return gcdCache.get(key);
        while( b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        gcdCache.put(key,a);
        return a;
    }
}
