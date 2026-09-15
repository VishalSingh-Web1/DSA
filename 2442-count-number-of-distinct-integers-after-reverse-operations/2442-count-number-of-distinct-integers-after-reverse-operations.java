class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int x:nums){
            set.add(x);
            set.add(reverse(x));
        }

        return set.size();
    }

    public static int reverse(int n){
        int rev =0;
        while(n!=0){
            int rem = n%10;
            rev = rev*10+rem;
            n = n/10;
        }
        return rev;
    }

}