class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int [] arr = new int [n];
        int pos = 0;
        int nev = 1;
        for(int i = 0 ; i <nums.length ; i++){
            if(nums[i]<= 0){
                arr[nev] = nums[i];
                nev += 2;
            }else{
                arr[pos] = nums[i];
                pos +=2;
            }
        }  
        return arr;   
    }
}
