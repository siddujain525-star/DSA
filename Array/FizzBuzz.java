/**
 * LC #412 - Fizz Buzz
 * Link: https://leetcode.com/problems/fizz-buzz/
 * Difficulty: Easy
 * Pattern: Loop + conditionals + List<String>
 *
 * Approach:
 * Loop from 1 to n inclusive.
 * Check divisibility by 3 AND 5 first.
 * Then check 3 only, then 5 only, else number.
 *
 * Time:  O(n)
 * Space: O(n) — result list of size n
 *
 * Key insight:
 * Check 3 AND 5 FIRST — if you check 3 first
 * you'll never reach the FizzBuzz condition.
 *
 * Common mistakes fixed:
 * i < n misses last number → use i <= n
 * "i" is literal string → use String.valueOf(i)
 * Always return the list at the end
 *
 * New concept learned:
 * String.valueOf(i) — converts int to String
 */
class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
