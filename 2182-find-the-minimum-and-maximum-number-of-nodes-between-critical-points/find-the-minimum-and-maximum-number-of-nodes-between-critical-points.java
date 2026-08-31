/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

        class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prev = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode p = head;
        ListNode c = head.next;
        int pos = 1;

        while (c.next != null) {

            // Check local maximum or minimum
            if ((c.val > p.val && c.val > c.next.val) ||
                (c.val < p.val && c.val < c.next.val)) {

                if (first == -1) {
                    first = pos;
                }

                if (prev != -1) {
                    minDist = Math.min(minDist, pos - prev);
                }

                prev = pos;
            }

            p = c;
            c = c.next;
            pos++;
        }

        // Fewer than two critical points
        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }

        int maxDist = prev - first;

        return new int[]{minDist, maxDist};
    }
}
    