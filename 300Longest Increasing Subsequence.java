public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int arr[]=new int[len];
        int max=1;
        Arrays.fill(arr,1);
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]&&arr[j]>=arr[i]){
                    arr[i]=1+arr[j];
                    if(max<arr[i]){
                        max=arr[i];
                    }
                }
            }
        }
        return max;
    }
}