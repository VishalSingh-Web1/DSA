class Solution {
    public int maxPower(String s) {
    int n = s.length();
    if (n == 0) return 0;
    
    char[] arr = s.toCharArray();
    int i = 0;
    int j = 0;
    int max = 0;
    
    while (j < n) {
        if (arr[i] == arr[j]) {
            j++;
        } else {
            max = Math.max(max, j - i);
            i = j;
        }
    }
    return Math.max(max, j - i); 
}

}