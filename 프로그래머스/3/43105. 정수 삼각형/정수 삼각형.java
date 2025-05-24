import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        
        for(int i=depth-2; i >=0; i--){
            int len = triangle[i].length;
            
            for(int j=0; j<len; j++){
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i+1][j], triangle[i+1][j+1]) ;
            }
        }
        
        return triangle[0][0];
    }
}