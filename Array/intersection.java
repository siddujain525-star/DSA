import java.util.ArrayList;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
     
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    
                    if (!ans.contains(nums1[i])) {
                        ans.add(nums1[i]); 
                    }
                  
                    break; 
                }
            }
        }   
        
 
        int[] result = new int[ans.size()];
        
        
        for (int k = 0; k < ans.size(); k++){ 
            result[k] = ans.get(k);
        }
        
        return result;
    } 
}
