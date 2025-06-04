import java.util.*;

class Solution {
    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static TreeSet<String> ts;
    
    public int solution(String word) {
        ts = new TreeSet<>();
        
        dfs("", 0);
        
        int index = 0;
        for(String s : ts){
            if(s.equals(word)){
                return index;
            }
            index++;
        }
        
        return 0;
    }
    
    static void dfs(String cur, int depth){
        ts.add(cur);
        
        if(depth>= 5){
            return; 
        }
        
        for(int i=0; i<5; i++){
            dfs(cur+chars[i], depth+1);
        }
    }
}