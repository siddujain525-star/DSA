/**
 * LC #1450 - Number of Students Doing Homework at a Given Time
 * Link: https://leetcode.com/problems/number-of-students-doing-homework-at-given-time/
 * Difficulty: Easy
 * Pattern: Single loop + condition check
 *
 * Approach:
 * Loop through each student once.
 * Check if queryTime falls between startTime[i] and endTime[i].
 * Count matches.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * Java doesn't support chained comparisons like Python.
 * a <= b <= c must be written as: a <= b && b <= c
 *
 * Common mistake fixed:
 * Removed unnecessary nested loop — single pass is enough.
 */
class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int attime = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                attime++;
            }
        }
        return attime;
    }
}
