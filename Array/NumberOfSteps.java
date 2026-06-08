/**
 * LC #1342 - Number of Steps to Reduce to Zero
 * Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * Difficulty: Easy
 * Pattern: Loop + modulo
 *
 * Approach:
 * While num > 0:
 * If even → divide by 2
 * If odd → subtract 1
 * Count every step.
 *
 * Time:  O(log n)
 * Space: O(1)
 *
 * Key insight:
 * Even numbers halve quickly — log n steps
 * Odd numbers need one subtraction first
 */
class NumberOfSteps {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            steps++;
        }
        return steps;
    }
}
