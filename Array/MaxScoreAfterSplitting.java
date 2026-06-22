```java
class Solution {
    public int maxScore(String s) {
        int totalOnes = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                totalOnes++;
            }
        }
        int maxScore = 0;
        int zeroleft = 0;
        int oneright = totalOnes;
        for (int i = 0 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) == '0'){
               zeroleft++;
            }else {
                oneright--;
            }
            int currentScore = zeroleft + oneright;
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }
        return maxScore;
    }
}done submitted and acceptes\
```
