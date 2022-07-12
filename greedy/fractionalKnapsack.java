class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
class Solution
{
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,new itemComparator());
        int w=0;
        double value=0.0;
        
        
        for(Item i:arr){
            if(w+i.weight<=W){
                w+=i.weight;
                value+=i.value;
            }
            else{
                int temp=W-w;
                value+=( (double)i.value/ (double)i.weight)* (double)(W-w);
                break;
            }
        }
        return value;
    }
        
}
