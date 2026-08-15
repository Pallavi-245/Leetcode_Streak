import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int i = 0;
        
        // Split s into primitive special binary substrings
        for (int j = 0; j < s.length(); j++) {
            count += (s.charAt(j) == '1') ? 1 : -1;
            
            if (count == 0) {
                // Recursively optimize the inside: "1" + sub + "0"
                list.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        
        // Sort primitive blocks descending to make the result lexicographically largest
        Collections.sort(list, Collections.reverseOrder());
        
        return String.join("", list);
    }
}