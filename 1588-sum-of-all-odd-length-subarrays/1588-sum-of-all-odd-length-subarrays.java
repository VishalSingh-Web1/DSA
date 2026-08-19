class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int totalSubarrays = (i + 1) * (n - i);
            
            int oddSubarrays = (totalSubarrays + 1) / 2;
            
            totalSum += oddSubarrays * arr[i]; 
        }
        
        return totalSum;
    }
}