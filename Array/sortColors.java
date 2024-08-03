class Solution {
    public void sortColors(int[] nums) {

        int low=0;
        int mid= 0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
            else{
                mid++;
            }
        }
        
    }
    void swap(int[] arr,int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
}
