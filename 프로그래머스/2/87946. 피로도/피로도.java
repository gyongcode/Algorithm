import java.util.*;

class Solution {
    static int len;
    static boolean[] selected;
    static int result = 0;
    static int[][] dungeons2;
    
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        
        selected = new boolean[len];
        dungeons2 = new int[len][2];
        for(int i=0; i<len; i++){
            dungeons2[i][0] = dungeons[i][0];
            dungeons2[i][1] = dungeons[i][1];
        }
        
        dfs(0, k, 0);
        
        return result;
    }
    
    static void dfs(int depth, int status, int cnt){
        result = Math.max(cnt, result);
       
        if(depth == len){
            return;
        }
        
        for(int i=0; i< len; i++){
            if(selected[i])
                continue;
            
            if(status < dungeons2[i][0])
                continue;
            
            selected[i] = true;
            dfs(depth+1, status-dungeons2[i][1], cnt+1);
            selected[i] = false;
            
        }
    }
}