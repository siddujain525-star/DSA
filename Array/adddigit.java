class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
/* 10 = 1 + 0 = 1
  11 = 1 + 1 = 2
  12 = 1 + 2 = 3
  .
  .
  goes on .... so 
  return 0 if 0 
  divisible by 9 then 9 
  if not divisible by 9 then modulo */
  
