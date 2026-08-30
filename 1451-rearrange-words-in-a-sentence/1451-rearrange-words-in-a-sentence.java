class Solution {
    public String arrangeWords(String text) {

        text = text.toLowerCase();

        String[] words = text.split(" ");

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            ans.append(word).append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);

        ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));

        return ans.toString();
    }
}