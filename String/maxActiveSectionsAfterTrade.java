class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int originalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                originalOnes++;
            }
        }

        int maxGain = 0;
        int i = 0;
        int prev = Integer.MIN_VALUE;
        int curr = 0;

        while (i < s.length()) {  
            int start = i ;
            // this loop is jsut finding the batch of 1s or 0r 
            while (i < s.length() && s.charAt(i) == s.charAt(start)) {
                i++;
            }

            // if the batch we proccess is zero then we are computing the gain only if we have encounter any previos batch of zero
            if (s.charAt(start) == '0') {
                curr = i-start;
                if(prev  != Integer.MIN_VALUE){
                    maxGain = Math.max(maxGain, curr+prev);
                }
                prev = curr;
            }           
        }

        return originalOnes + maxGain;
    }
}
