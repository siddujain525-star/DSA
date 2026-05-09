/**
 * LC #383 - Ransom Note
 * Link: https://leetcode.com/problems/ransom-note/
 * Difficulty: Easy
 * Pattern: Frequency Count (int[26])
 *
 * Approach:
 * Count frequency of each character in magazine using int[26].
 * Then for each character in ransomNote, decrement its count.
 * If any count goes below 0 → magazine can't construct ransomNote.
 *
 * Time:  O(n)
 * Space: O(1) — fixed size array of 26
 *
 * Key insight: c - 'a' converts any lowercase char to index 0-25.
 * int[26] is preferred over HashMap when only lowercase letters involved.
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }

        return true;
    }
}

