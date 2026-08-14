class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int i =1;

        while(i<n&&nums[i]==nums[i-1]+1){
            sum = sum+nums[i];
            i++;
        }
        Set<Integer> present = new HashSet<>();
        for (int x : nums) present.add(x);
        
        while (present.contains(sum)) {
            sum++;
        }
        return sum;
    }
}