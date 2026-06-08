/**
 * LC #2894 - Divisible and Non-Divisible Sums Difference
 * Link: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
 * Difficulty: Easy
 * Pattern: Loop + modulo
 *
 * Approach:
 * Loop from 0 to n inclusive.
 * If i divisible by m → add to num2
 * Else → add to num1
 * Return num1 - num2
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * % operator checks divisibility.
 * i % m == 0 means i is divisible by m.
 * Simple if/else separates the two groups.
 */
class DifferenceOfSums {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1 - num2;
    }
}
