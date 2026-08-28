class Solution {
    public String lexPalindromicPermutation(String s, String target) {
    

        int n = s.length();
        int[] cnt = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check palindrome possibility
        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Count characters available for left half
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        int halfLen = n / 2;
        char[] half = new char[halfLen];

        // Try to match target's first half
        int matched = 0;

        for (int i = 0; i < halfLen; i++) {

            int x = target.charAt(i) - 'a';

            if (halfCnt[x] == 0) {
                break;
            }

            half[i] = target.charAt(i);
            halfCnt[x]--;
            matched++;
        }

        // Case 1: target's half could not be completely matched
        if (matched < halfLen) {

            // Try to make current position bigger
            for (int i = matched; i >= 0; i--) {

                if (i < matched) {
                    halfCnt[half[i] - 'a']++;
                }

                int x = target.charAt(i) - 'a';

                for (int c = x + 1; c < 26; c++) {

                    if (halfCnt[c] > 0) {

                        half[i] = (char)('a' + c);
                        halfCnt[c]--;

                        fillRemaining(half, i + 1, halfCnt);

                        return makePalindrome(half, mid);
                    }
                }
            }

            return "";
        }

        // Target's complete first half matched.
        // Check if the palindrome itself is already greater.
        String current = makePalindrome(half, mid);

        if (current.compareTo(target) > 0) {
            return current;
        }

        // Need the next greater half.
        for (int i = halfLen - 1; i >= 0; i--) {

            int old = half[i] - 'a';
            halfCnt[old]++;

            for (int c = old + 1; c < 26; c++) {

                if (halfCnt[c] > 0) {

                    half[i] = (char)('a' + c);
                    halfCnt[c]--;

                    fillRemaining(half, i + 1, halfCnt);

                    return makePalindrome(half, mid);
                }
            }
        }

        return "";
    }

    private void fillRemaining(char[] half, int pos, int[] cnt) {

        for (int c = 0; c < 26; c++) {

            while (cnt[c] > 0) {
                half[pos++] = (char)('a' + c);
                cnt[c]--;
            }
        }
    }

    private String makePalindrome(char[] half, int mid) {

        StringBuilder ans = new StringBuilder();

        // Left half
        for (char c : half) {
            ans.append(c);
        }

        // Middle character
        if (mid != -1) {
            ans.append((char)('a' + mid));
        }

        // Right half
        for (int i = half.length - 1; i >= 0; i--) {
            ans.append(half[i]);
        }

        return ans.toString();
    }
}
