class Solution {
    public int numSquares(int n) {
        // dp[i] will store the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];
        
        // Initialize the DP array with a maximum possible value (i)
        // because the worst case is summing 1s (e.g., 1+1+1...)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            // Try all perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        
        return dp[n];
    }
}
