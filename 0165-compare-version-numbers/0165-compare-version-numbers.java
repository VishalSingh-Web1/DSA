class Solution {
    public int compareVersion(String version1, String version2) {
        // Split strings using regex; escape the dot character
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int maxLength = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < maxLength; i++) {
            // If index is out of bounds, treat the revision value as 0
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        
        return 0;
    }
}
