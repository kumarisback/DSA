class Solution {
    public void nextPermutation(int[] nums) {
        
        int index=-1;
        int len= nums.length-1;

      //find the first pair from right where left elment is smaller then right
        for(int i=len-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            int i=0;
            int j=len;
            while(i<j){
                swap( nums,i,j);
                i++;
                j--;
            }
            return;
        }

//swap smaller element from elment greater then this from right side
        for(int i=len;i>index;i--){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }
//sort part between index till the end
        int i=index+1;
        int j=len;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
