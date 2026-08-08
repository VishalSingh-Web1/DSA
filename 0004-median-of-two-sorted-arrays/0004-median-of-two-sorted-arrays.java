class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length; 
        int k = 0;
        int l=0;
        float me = 0;
        int[] arr = new int[m+n];
        for(int i=0;i<m;i++){
            arr[i]=nums1[i];
        }
        for(int j=m;j<m+n;j++){
            arr[j]=nums2[k];
            k++;
        }
       Arrays.sort(arr);

        int len = arr.length;

        // Odd length
        if (len % 2 != 0) {
            return arr[len / 2];
        }
        // Even length
        return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
    }
}