class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int i = 0 ; i < accounts.length ; i++){
            int ccWealth = 0;
            for(int j = 0 ; j < accounts[i].length ; j++){
                ccWealth += accounts[i][j];

                maxWealth = Math.max(maxWealth , ccWealth );
            }

        }

        return maxWealth;
        
    }
}
