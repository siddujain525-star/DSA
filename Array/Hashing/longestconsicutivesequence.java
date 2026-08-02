class Solution {
    public int longestConsecutive(int[] nums) {
        if( nums.length == 0){
            return 0;
        }
        Set<Integer>table = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            table.add(nums[i]);
        }
        int maxlength = 1;
        for(int num : table){
            if(!table.contains(num -1 )){
                int currentNum = num;
                int length = 1;

                while(table.contains(currentNum + 1)){
                    currentNum++;
                    length++;
                }
                maxlength = Math.max(maxlength,length);
            }
        }
        return maxlength;
    }
}
