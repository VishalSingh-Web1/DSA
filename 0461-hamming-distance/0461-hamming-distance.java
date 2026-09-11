class Solution {
    public int hammingDistance(int x, int y) {
        // XOR isolates the differing bits, bitCount counts them
        return Integer.bitCount(x ^ y);
    }
}
