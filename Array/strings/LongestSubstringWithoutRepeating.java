/**
 * LC #3 - Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Difficulty: Medium
 * Pattern: Sliding window + HashSet
 *
 * Approach:
 * Use sliding window with HashSet to track characters in window.
 * Expand right pointer — add character to set.
 * If character already in set → shrink left until removed.
 * Track maximum window size throughout.
 *
 * Time:  O(n)
 * Space: O(n) — HashSet stores window characters
 *
 * Key insight: HashSet gives O(1) lookup to check if
 * character already exists in current window.
 * Shrink left until duplicate removed, then expand right.
 *
 * Variables:
 * left  — start of window
 * right — end of window
 * set   — characters currently in window
 * maxLength — result
 */
class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
