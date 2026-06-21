/**
 * LC #1184 - Distance Between Bus Stops
 * Link: https://leetcode.com/problems/distance-between-bus-stops/
 * Difficulty: Easy
 * Pattern: Array sum + circular distance
 *
 * Approach:
 * Calculate total distance (sum of entire array).
 * Calculate clockwise distance (sum from min(start,dest) to max(start,dest)).
 * Counter-clockwise = total - clockwise.
 * Return the minimum of the two.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * Don't assume start < destination.
 * Always normalize with Math.min and Math.max first,
 * since the route is circular and direction doesn't matter
 * for calculating the shorter path.
 *
 * Common mistake fixed:
 * Original condition (i >= start && i < destination)
 * failed when start > destination, since no index
 * could satisfy both conditions.
 */
class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int totalDistance = 0;
        for (int i = 0; i < n; i++) {
            totalDistance += distance[i];
        }

        int start2 = Math.min(start, destination);
        int end2 = Math.max(start, destination);

        int clockwiseDistance = 0;
        for (int i = start2; i < end2; i++) {
            clockwiseDistance += distance[i];
        }

        int counterClockwiseDistance = totalDistance - clockwiseDistance;
        return Math.min(clockwiseDistance, counterClockwiseDistance);
    }
}
