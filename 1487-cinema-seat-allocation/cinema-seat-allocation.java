import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number to bitmask of reserved seats
        Map<Integer, Integer> rowReservations = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // Seats 1 and 10 do not affect 4-person groups
            if (col >= 2 && col <= 9) {
                rowReservations.put(row, rowReservations.getOrDefault(row, 0) | (1 << col));
            }
        }
        
        // Rows with no relevant reservations can each hold 2 groups
        int totalGroups = (n - rowReservations.size()) * 2;
        
        // Bitmasks for the three possible 4-seat placements
        int leftMask   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5); // Seats 2, 3, 4, 5
        int rightMask  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9); // Seats 6, 7, 8, 9
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7); // Seats 4, 5, 6, 7
        
        for (int mask : rowReservations.values()) {
            boolean leftFree   = (mask & leftMask) == 0;
            boolean rightFree  = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;
            
            if (leftFree && rightFree) {
                totalGroups += 2;
            } else if (leftFree || rightFree || middleFree) {
                totalGroups += 1;
            }
        }
        
        return totalGroups;
    }
}