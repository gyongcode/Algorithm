import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static int[][] map;
    static int[] dx = {0, 1}, dy ={1, 0};
    static int X, Y;
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n+1][m+1];
        
        for(int[] puddle : puddles){
            int r = puddle[1];
            int c = puddle[0];
            map[r][c] = -1;
        }
        map[1][1] = 1;
        
        for(int i=1; i<= n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1)
                    continue;
                
                int a = map[i-1][j]==-1?0:map[i-1][j];
                int b = map[i][j-1]==-1?0:map[i][j-1];
                
                map[i][j] += (a+b) % MOD;
                // System.out.printf("%d  %d  %d\n",i ,j ,map[i][j]);
            }
        }
        
        return map[n][m];
    }
    
}