/**
 * LC #206 - Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * Difficulty: Easy
 * Pattern: Linked list — two pointers
 *
 * Approach:
 * Three variables — previous, current, nextNode
 * Every iteration does 4 steps:
 * 1. Save next node before losing it
 * 2. Reverse pointer — current.next = previous
 * 3. Move previous forward
 * 4. Move current forward
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * Save nextNode BEFORE reversing pointer.
 * Once current.next = previous — node ahead is lost forever.
 * nextNode acts as bookmark to continue traversal.
 *
 * Analogy:
 * Chain of people holding hands.
 * Tap next person before letting go.
 * Then grab previous person's hand.
 * Walk forward to tapped person.
 * Repeat.
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}
