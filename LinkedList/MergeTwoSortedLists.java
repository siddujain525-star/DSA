/**
 * LC #21 - Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 * Difficulty: Easy
 * Pattern: Linked list — dummy node
 *
 * Approach:
 * Create dummy node as fake head.
 * Compare list1 and list2 values each iteration.
 * Attach smaller node to current.next.
 * Move that list pointer forward.
 * Move current forward.
 * Attach remaining list at end.
 *
 * Time:  O(n+m)
 * Space: O(1)
 *
 * Key insight:
 * Dummy node trick — avoids edge cases for head.
 * Build result by attaching to current.next.
 * Return dummy.next as real head at end.
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
}
