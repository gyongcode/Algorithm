import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int len;
    static boolean[] selected;
    
    public int solution(String numbers) {
        len = numbers.length();
        selected = new boolean[len];
        
        dfs(numbers, 0);
        
        int cnt = 0;
        for(int i : set){
            if(isPrime(i))
                cnt++;
        }
        
        return cnt;
    }
    
    static void dfs(String numbers, int cur){
        for(int i=0; i<len; i++){
            if(selected[i])
                continue;
            
            selected[i] = true;
            int tmp = cur*10 + numbers.charAt(i) - '0';
            set.add(tmp);
            dfs(numbers, tmp);;
            selected[i] = false;
        }
    }
    
    
    
    static boolean isPrime(int n){
        if(n < 2)
            return false;
        
        for(int i = 2; i * i<=n; i++){
            if(n % i == 0)
                return false;
        }
        
        return true;
    }
    
    
}