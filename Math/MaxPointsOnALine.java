class Solution {
    public int maxPoints(int[][] points) {
        int result = 0;

        int n = points.length;

        if (n <= 2)
            return n;

        for(int i = 0; i < n ;i++){
            Map<String,Integer> map= new HashMap<>();

            int max = 0;

            for(int j = i+1 ; j < n ; j++){
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];

                int g = gcd(dx,dy);

                dx /= g;
                dy /= g;

                // Keep denominator positive because 2/-3, -2/3 will be treatead as different key even they have same slope
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // this is to if line is vertical with x value 0 then 2/0, 3/0 will again treated as diffent key even they have same slop 
                if(dx == 0){
                    dy = 1;
                }
                // same here this is to if line is horizontal with y value 0 then 0/2, 0/3 will again treated as diffent key even they have same slop 
                if(dy == 0 ){
                    dx = 1;
                }

                String key = dy+"/"+dx;

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key,count);
                max = Math.max(count,max);
            }
            result = Math.max(max+1,result);
        }
        return result;
    }

    public int gcd(int a , int b){
        if(b == 0){
            return Math.abs(a);
        }
        return gcd(b, a%b);
    }
}
