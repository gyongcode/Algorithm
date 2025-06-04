import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : lost){
            set.add(i);
        }
        
        for(int i=0; i<reserve.length; i++){
            // System.out.println(reserve[i]);
            if(set.contains(reserve[i])){
                set.remove(reserve[i]);
                reserve[i] = -1;
            }
        }
        
        Arrays.sort(reserve);
        for(int i : reserve){
            if(set.contains(i-1)){
                set.remove(i-1);
                continue;
            }
            else if(set.contains(i+1)){
                set.remove(i+1);
            }
        }

        return n - set.size();
    }
}