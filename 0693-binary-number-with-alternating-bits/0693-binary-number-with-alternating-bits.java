class Solution {
    public boolean hasAlternatingBits(int n) {
        // Step 1: XOR n with itself shifted right by 1
        int x = n ^ (n >> 1);
        
        // Step 2: Check if x has all 1s by validating if (x & (x + 1)) == 0
        return (x & (x + 1)) == 0;
    }
}
