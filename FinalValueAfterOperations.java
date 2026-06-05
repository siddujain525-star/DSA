/**
 * LC #2011 - Final Value of Variable After Operations
 * Link: https://leetcode.com/problems/final-value-of-variable-after-operations/
 * Difficulty: Easy
 * Pattern: String + charAt
 *
 * Approach:
 * Loop through operations array.
 * Check middle character charAt(1).
 * If '+' → increment x.
 * If '-' → decrement x.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * charAt(1) always gives the operator
 * regardless of format (X++ or ++X)
 * Middle character is always + or -
 *
 * New concept learned:
 * String charAt(index) — gets character at position
 * "X++".charAt(1) = '+'
 * "--X".charAt(1) = '-'
 middle character shows the result of the whole operation, so use it 
 */
class FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
