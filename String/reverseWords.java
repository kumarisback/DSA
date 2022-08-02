class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] res = s.split(" ");
        s=res[res.length-1];
        for(int i=res.length-2;i>=0;i--){
            String t=res[i].trim();
            if(t!="")
                s =s+ (" "+t);
        }
        return s;
    }
}
