class Solution {
    private boolean possible(int[] bloomDay, int day, int m, int k) {
        int cnt = 0;
        int noOfB = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0; 
            }
        }
        noOfB += (cnt / k); 
        
        return noOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        if(val > bloomDay.length){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i <bloomDay.length; i++){
            mini = Math.min(mini,bloomDay[i]);
            maxi = Math.max(maxi,bloomDay[i]);
        }
        int low = mini;
        int high = maxi ;
        while(low < high){
            int mid = low+(high - low)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return low;
    }
}
