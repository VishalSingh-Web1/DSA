class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(s, 0, list, ans);

        return ans;
    }

    static void solve(String s, int start,
                      List<String> list,
                      List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = start + 1; j <= s.length(); j++) {

            String sub = s.substring(start, j);

            if (isPalindrome(sub)) {

                list.add(sub);

                solve(s, j, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}