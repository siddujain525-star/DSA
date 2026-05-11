/**
 * LC #1431 - Kids With the Greatest Number of Candies
 * Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Difficulty: Easy
 * Pattern: Array + ArrayList
 *
 * Approach:
 * Step 1 — find maximum candy count in array
 * Step 2 — for each kid check if candies[i] + extraCandies >= max
 * If yes → add true to result list
 * If no  → add false to result list
 *
 * Time:  O(n)
 * Space: O(n) — result list of size n
 *
 * New concepts learned:
 * List<Boolean> — list of true/false values
 * ArrayList     — dynamic list in Java
 * result.add(true) / result.add(false) — adding to list
 *
 * Key rules learned today:
 * 1. if statement MUST be inside loop when using loop variable
 * 2. Always check return type before coding
 *    public List<Boolean> → must return List<Boolean>
 */
class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
