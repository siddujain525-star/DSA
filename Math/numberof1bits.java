/**
 * LC #191 - Number of 1 Bits
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * Difficulty: Easy
 * Pattern: Bit manipulation — mask
 *
 * Approach:
 * Use a mask starting at 1.
 * Check each bit of n using mask & n.
 * Shift mask left by 1 each iteration.
 * Repeat 32 times for all bits.
 *
 * Time:  O(32) = O(1)
 * Space: O(1)
 *
 * Key insight:
 * mask & n != 0 means that bit position is 1
 * mask <<= 1 moves to check next bit
 *
 * Common mistakes fixed:
 * !== → != (Java not JavaScript)
 * msak → mask (typo)
 */
class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
