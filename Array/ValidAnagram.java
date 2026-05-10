/**
 * LC #242 - Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * Difficulty: Easy
 * Pattern: Character frequency counting
 *
 * Approach:
 * Use int[26] array to count character frequencies.
 * Increment for every char in s.
 * Decrement for every char in t.
 * If any count goes negative → t has extra char → not anagram.
 *
 * Time:  O(n)
 * Space: O(1) — fixed size array of 26, not dependent on input
 *
 * Key insight: c - 'a' maps characters to indices.
 * 'a'=0, 'b'=1, 'c'=2 ... 'z'=25
 * Faster and cleaner than HashMap for character problems.
 *
 * Common mistakes fixed today:
 * - CharAt() → charAt() (lowercase c always)
 * - letter o vs number 0 in loop
 * - Always declare variables with int keyword
 */
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
