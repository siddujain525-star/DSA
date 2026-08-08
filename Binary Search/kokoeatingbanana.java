class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        int low = 1;
        int high = max;
        
        while(low<=high){
            int mid =low +(high-low)/2;
            long hours = calculateHours(piles,mid);
            if(hours <= h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;        
    }
    public long calculateHours(int []piles,int bananas){
        long count = 0;
        for(int i = 0 ; i<piles.length;i++){
            if(piles[i]%bananas==0){
                count += piles[i]/bananas;
            }else{
                count+= piles[i]/bananas + 1;
            }
        }
        return count;
    }
}
