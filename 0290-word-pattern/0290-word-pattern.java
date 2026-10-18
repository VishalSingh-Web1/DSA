class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If the number of letters and words do not match, return false
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Set<String> assignedWords = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (charToWord.containsKey(ch)) {
                // If the character was already mapped, check if it maps to the same word
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // If the word is already assigned to another character, return false
                if (assignedWords.contains(word)) {
                    return false;
                }
                charToWord.put(ch, word);
                assignedWords.add(word);
            }
        }
        
        return true;
    }
}
