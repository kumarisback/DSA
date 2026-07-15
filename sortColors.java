class Solution {
    public void sortColors(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums,mid, high);
                high--;
            }
        }
    }

    public void swap(int[] num , int x ,int y){
        int temp = num[x];
        num[x]= num[y];
        num[y] = temp;
    }
}
