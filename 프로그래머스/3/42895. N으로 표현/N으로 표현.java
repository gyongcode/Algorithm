import java.util.*;

class Solution {
        
    
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        if(N == number)
            return 1;
        
        for(int i=0; i<9; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        
        for(int i = 2; i<9; i++){
            HashSet<Integer> cur = list.get(i);
            
            for(int j = 1; j<i; j++){
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i-j);
                
                for(int pre : preSet){
                    for(int post : postSet){
                        cur.add(pre + post);
                        cur.add(pre - post);
                        cur.add(pre * post);
                        
                        if(pre != 0 && post != 0){
                            cur.add(pre/post);
                        }
                    }
                }
                
            }
            
            cur.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            if(cur.contains(number))
                return i;
        }
        return -1;
    }
    
    
}