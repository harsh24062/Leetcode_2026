// time complexity - n*log(m)

class Solution {
    int binarySearch(int nums[], int num){
        int left=0,right=nums.length-1;
        int index=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=num){
                index=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return index;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for(int i=0;i<nums1.length;i++){
            int index = binarySearch(nums2,nums1[i]);
            if(index!=-1)maxDistance = Math.max(maxDistance,index-i);
        }
        return maxDistance;
    }
}


// O(N)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int max=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                i++;
            }else{
                max=Math.max(max,j-i);
                j++;
            }
        }
        return max;
    }
}
