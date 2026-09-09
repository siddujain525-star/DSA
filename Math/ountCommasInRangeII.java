/**
 * LC #3472 - Count Commas in Range II
 * Link: https://leetcode.com/problems/count-commas-in-range-ii/
 * Difficulty: Medium
 * Pattern: Math — counting by threshold
 *
 * Approach:
 * For each comma threshold (1000, 1000000, 1000000000...):
 * Count how many numbers from p to n exist = n - p + 1
 * Each such number has at least one comma at that level.
 * Numbers with multiple commas get counted multiple times
 * automatically — once per threshold they exceed.
 *
 * Time:  O(log n) — number of comma thresholds
 * Space: O(1)
 *
 * Key insight:
 * n - p + 1 = count of numbers from p to n inclusive
 * A number like 1,000,000 gets counted at p=1000 AND
 * p=1000000 — contributing 2 to total. Correct.
 *
 * Trace for n=1002:
 * p=1000: res += 1002-1000+1 = 3
 * return 3 ✅
 *
 * Trace for n=1004590:
 * p=1000:    res += 1003591
 * p=1000000: res += 4591
 * return 1008182 ✅
 */
class CountCommasInRangeII {
    public long countCommas(long n) {
        long p = 1000;
        long res = 0;
        while (p <= n) {
            res += (n - p + 1);
            p *= 1000;
        }
        return res;
    }
}
