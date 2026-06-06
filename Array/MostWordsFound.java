/**
 * LC #2114 - Maximum Number of Words Found in Sentences
 * Link: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 * Difficulty: Easy
 * Pattern: String + nested loops
 *
 * Approach:
 * Loop through every sentence.
 * Count spaces in each sentence using inner loop.
 * Words = spaces + 1.
 * Track maximum word count.
 *
 * Time:  O(n×m) — n sentences, m average length
 * Space: O(1)
 *
 * Key insight:
 * Words = spaces + 1 always.
 * Counting spaces is easier than counting words.
 *
 * New concepts learned:
 * sentences.length   → array length (no brackets)
 * sentence.length()  → string length (with brackets)
 * sentence.charAt(j) → character at index j
 * String sentence = sentences[i] → save current
 * string to avoid writing sentences[i] repeatedly
 *
 * Common mistake fixed:
 * Outer loop uses i — inner loop uses j
 * Never use i inside inner loop for charAt or length
 */
class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            int spaceCount = 0;

            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == ' ') {
                    spaceCount++;
                }
            }

            int wordCount = spaceCount + 1;
            if (wordCount > max) {
                max = wordCount;
            }
        }
        return max;
    }
}
