class Solution {
    public boolean checkDivisibility(int n) {
        
        if (n == 0) return false;
        int temp = n;
        int sum = 0;
        int pro = 1;
        while(temp>0){
            int rem = temp%10;
            sum = sum + rem;
            pro = pro*rem;
            temp = temp/10;
        }
        int res = sum+pro;
        if (res == 0) {
            return false; 
        }
        
        return n % res == 0; 
    }
}