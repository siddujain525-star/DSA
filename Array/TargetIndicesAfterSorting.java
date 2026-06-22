class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        List<Integer>output = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if (nums[i] == target){
                output.add(i);

            }
        }

        return output;
    }
}
