class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int one = 0;
        String ans = "";
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (s.charAt(end) == '1') {
                one++;
            }

            // Shrink window if ones exceed k or to strip leading '0's
            while (one > k || (start < end && s.charAt(start) == '0')) {
                if (s.charAt(start) == '1') {
                    one--;
                }
                start++;
            }

            // When exactly k ones are present, compare with current best
            if (one == k) {
                String sub = s.substring(start, end + 1);
                if (ans.isEmpty() || sub.length() < ans.length() || (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
                    ans = sub;
                }
            }
        }

        return ans;
    }
}