class Solution {
    public String convertToBase7(int num) {
        // Base case: if the number is 0, its base 7 representation is "0"
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        
        // Use the absolute value for calculations
        long n = Math.abs((long) num);
        
        // Process digits from right to left
        while (n > 0) {
            sb.append(n % 7);
            n /= 7;
        }
        
        // Append the negative sign if the original number was negative
        if (isNegative) {
            sb.append("-");
        }
        
        // Reverse the string since digits were added backwards
        return sb.reverse().toString();
    }
}
