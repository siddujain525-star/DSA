class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Base cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        // Search range excluding the verified boundaries
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the unique element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // In the left half, duplicate pairs start at an even index and end at an odd index
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) 
                || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }

        return -1;
    }
}
