class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] c= new int[len];
        for (int i = 0 ; i < len ; i++){
            c[i] = 1;
            if(i > 0 && ratings[i] > ratings[i-1]){
                c[i]= c[i-1]+1;
            }
        }  

        for (int i = len-2 ; i >= 0 ; i--){
            if( ratings[i] > ratings[i+1]){
                c[i] = Math.max(c[i], c[i+1]+1);
            }
        }   

        int sum = 0 ;
        for (int i = 0 ; i < len ; i++){
            sum+= c[i];
        }  
        return sum;
    }
}
