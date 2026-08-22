/**
 * LC #3622 - Check Divisibility by Digit Sum and Product
 * Link: leetcode.com/problems/check-divisibility-by-digit-sum-and-product
 * Difficulty: Easy
 * Pattern: Math + digit extraction
 *
 * Approach:
 * Extract each digit using temp % 10
 * Add to sum, multiply to product
 * Divide temp by 10 to move to next digit
 * Check if n % (sum + product) == 0
 *
 * Time:  O(log n) — number of digits
 * Space: O(1)
 *
 * Key insight:
 * temp % 10 extracts last digit
 * temp / 10 removes last digit
 * Repeat until temp = 0
 */
class CheckDivisibilityByDigitSumAndProduct {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return n % (sum + product) == 0;
    }
}
