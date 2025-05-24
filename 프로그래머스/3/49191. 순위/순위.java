import java.util.*;
//asdfsdaf
class Solution {
    static boolean[][] visited;
    
    
    public int solution(int n, int[][] results) {
        visited = new boolean[n+1][n+1];
        for(int i=1; i<n+1; i++){
            visited[i][i] = true;
        }
        for(int[] result : results){
            visited[result[0]][result[1]] = true;
        }
        
        fw(n);
        
        int result = 0;
        
        for(int i=1; i<n+1; i++){
            int cnt = 0;
            for(int j=1; j<n+1; j++){
                if(visited[i][j] || visited[j][i]){
                    cnt++;
                }
            }
            if(cnt == n){
                result++;
            }
        }
        return result;
        
    }
    
    static void fw(int n){
        for(int k =1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(visited[i][k] && visited[k][j]){
                        visited[i][j] = true;                    
                    }
                }
            }
        }
    }
}