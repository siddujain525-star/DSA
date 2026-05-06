/**
 * LC #169 - Majority Element
 * Link: https://leetcode.com/problems/majority-element/
 * Difficulty: Easy
 * Pattern: HashMap
 *
 * Approach:
 * Count occurrences of each number using HashMap.
 * Return the number whose count exceeds n/2.
 *
 * Time:  O(n)
 * Space: O(n)
 *
 * Key insight: HashMap stores each number as key and its
 * count as value. getOrDefault avoids checking containsKey
 * separately — cleaner one line counting.
 *
 * New concept learned:
 * getOrDefault(key, 0) — returns value if key exists,
 * returns 0 if it doesn't. Avoids if/else for counting.
 */
class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()) {
            if (count.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}
