class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // last[j] stores the largest index in word1 that matches word2[j] 
        // to form the suffix word2[j...m-1]
        int[] last = new int[m];
        int idx = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (idx >= 0 && word1.charAt(idx) != word2.charAt(j)) {
                idx--;
            }
            last[j] = idx;
            if (idx >= 0) {
                idx--;
            }
        }
        
        int[] result = new int[m];
        boolean usedMismatch = false;
        int j = 0;
        
        for (int i = 0; i < n && j < m; i++) {
            boolean isMatch = word1.charAt(i) == word2.charAt(j);
            
            if (isMatch) {
                result[j] = i;
                j++;
            } else if (!usedMismatch) {
                // If this is the last character of word2 OR remainder can be matched using precomputed suffix
                if (j == m - 1 || last[j + 1] > i) {
                    usedMismatch = true;
                    result[j] = i;
                    j++;
                }
            }
        }
        
        return j == m ? result : new int[0];
    }
}