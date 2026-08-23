class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumLeft = 0, sumRight = 0;
        int countLeft = 0, countRight = 0;
        
        // Process the first half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                countLeft++;
            } else {
                sumLeft += num.charAt(i) - '0';
            }
        }
        
        // Process the second half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                countRight++;
            } else {
                sumRight += num.charAt(i) - '0';
            }
        }
        
        // If the total number of '?' is odd, Alice gets the last move and wins
        if ((countLeft + countRight) % 2 != 0) {
            return true;
        }
        
        // Check if Bob can balance the game using the 4.5 average rule
        return 2 * (sumLeft - sumRight) != 9 * (countRight - countLeft);
    }
}