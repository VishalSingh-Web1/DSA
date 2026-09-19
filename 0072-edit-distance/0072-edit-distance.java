class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] represents the minimum operations to convert 
        // the first i characters of word1 to the first j characters of word2.
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: converting word1 (length i) to an empty string requires i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Base case: converting an empty string to word2 (length j) requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, no new operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Otherwise, consider all three operations and take the minimum
                    int insertOp = dp[i][j - 1];   // Insert
                    int deleteOp = dp[i - 1][j];   // Delete
                    int replaceOp = dp[i - 1][j - 1]; // Replace
                    
                    dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
                }
            }
        }
        
        return dp[m][n];
    }
}

