/**
 * LC #125 - Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/
 * Difficulty: Easy
 * Pattern: Two Pointers
 *
 * Approach:
 * Two pointers — left at start, right at end.
 * Skip non-alphanumeric characters from both sides.
 * Compare lowercase characters moving inward.
 * If mismatch found → return false.
 * If pointers meet in middle → return true.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight: Two pointers avoid nested loops — each
 * pointer travels array once = O(n) instead of O(n²).
 * Skip non-alphanumeric with inner while loops before
 * comparing.
 *
 * Methods used:
 * Character.isLetterOrDigit(c) — checks a-z, A-Z, 0-9
 * Character.toLowerCase(c)    — converts to lowercase
 * s.charAt(i)                 — gets char at index i
 */
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
