import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
 
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int totalSum = 0;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            
            if (frequency % k == 0) {
                totalSum += element * frequency;
            }
        }
        
        return totalSum;
    }
}
