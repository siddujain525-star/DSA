/**
 * LC #190 - Reverse Bits
 * Link: https://leetcode.com/problems/reverse-bits/
 * Difficulty: Easy
 * Pattern: Bit manipulation — mask
 *
 * Approach:
 * Use mask starting at 1.
 * Check each bit of n using mask & n.
 * If bit is 1 → place it at mirrored position (31-i).
 * Shift mask left each iteration.
 * Repeat 32 times.
 *
 * Time:  O(32) = O(1)
 * Space: O(1)
 *
 * Key insight:
 * Bit at position i goes to position 31-i
 * 1 << (31-i) places the bit correctly
 * Operator precedence: always use brackets
 * 1 << 32-i reads as 1 << (32-i) — off by one
 *
 * Common mistake fixed:
 * 1 << 32-i → 1 << (31-i)
 */
class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                ans += 1 << (31 - i);
            }
            mask <<= 1;
        }
        return ans;
    }
}
