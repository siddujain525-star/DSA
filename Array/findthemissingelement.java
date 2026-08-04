class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int min = (nums[0]);
        int max = (nums[nums.length - 1]);
        int j = 0;
        for(int i = min ; i <= max; i++){
            if(i == nums[j]){
                 j++;
            }
            else{
                list.add(i);
            }
 
        }
        return list;
    }
}
