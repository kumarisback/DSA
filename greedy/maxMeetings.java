class meeting
{
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
 
class mycomparator implements Comparator<meeting>{
    @Override
    public int compare(meeting o1, meeting o2){
        if(o1.end>o2.end) return 1;
        if( o1.end<o2.end) return-1;
        return 0;
    }
}
class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<meeting> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new meeting(start[i],end[i],i));
        }
        mycomparator c = new mycomparator();
        Collections.sort(l,c);
        
        int itr=l.get(0).end;
        int limit=1;
        
        for(meeting m: l){
            if(m.start>itr) {
                limit++;
                itr=m.end;
            }
        }
        return limit;
    }
}
