class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the root word at the end node
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for (String dictWord : dictionary) {
            TrieNode curr = root;
            for (char c : dictWord.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = dictWord; // Mark the end of a valid root word
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(findRoot(words[i], root));
        }

        return result.toString();
    }

    private String findRoot(String word, TrieNode root) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (curr.children[index] == null) {
                return word;
            }
            
            curr = curr.children[index];
            
            if (curr.word != null) {
                return curr.word;
            }
        }
        return word;
    }
}