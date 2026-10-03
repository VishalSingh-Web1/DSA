class Solution {
    public String toHex(int num) {
        // Base case: if the number is zero, return "0" immediately
        if (num == 0) {
            return "0";
        }
        
        // Hexadecimal digit mapping
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        
        // Process the 32-bit integer 4 bits at a time
        while (num != 0) {
            // Get the last 4 bits of the number
            int lastFourBits = num & 15; // 15 is 1111 in binary
            sb.append(hexChars[lastFourBits]);
            
            // Perform a logical right shift by 4 bits
            // >>> shifts in 0s from the left, safely handling negative numbers (two's complement)
            num >>>= 4;
        }
        
        // Since we processed from right to left, reverse the result
        return sb.reverse().toString();
    }
}
