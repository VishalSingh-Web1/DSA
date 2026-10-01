import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 1. Find the global minimum and maximum values
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // If all elements are the same, the max gap is 0
        if (minVal == maxVal) {
            return 0;
        }

        int n = nums.length;

        // 2. Calculate bucket size and count
        // We use Math.max(1, ...) to prevent division by zero
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        // Arrays to store the min and max elements for each bucket
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 3. Distribute each number into its respective bucket
        for (int num : nums) {
            int bucketIdx = (num - minVal) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // 4. Calculate the maximum gap between successive non-empty buckets
        int maxGap = 0;
        int prevMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            // The gap is measured between the current bucket's minimum 
            // and the previous non-empty bucket's maximum
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}
