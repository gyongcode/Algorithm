import java.util.*;

class Solution {
    static int N;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] wires) {        
        N = n;
        
        adj = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i < N-1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
        
            adj[a].add(b);
            adj[b].add(a);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i < N-1; i++){
            int a = wires[i][0];
            int b = wires[i][1];
        
            for(int j=0; j < adj[a].size(); j++){
                if(adj[a].get(j) == b)
                    adj[a].remove(j);
            }
            
            for(int j=0; j < adj[b].size(); j++){
                if(adj[b].get(j) == a)
                    adj[b].remove(j);
            }
            
            
            
            int tmp = bfs(1);
            min = Math.min(min, Math.abs(N-tmp-tmp));
            adj[b].add(a);
            adj[a].add(b);
            
        }
        
        
        return min;
    }
    
    
    static int bfs(int x){
        boolean[] visited = new boolean[N+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(x);
        visited[x] = true;
        int res = 1;
        
        while(!dq.isEmpty()){
            int cur = dq.removeFirst();
            
            for(int newx : adj[cur]){
                if(visited[newx])
                    continue;
                
                res++;
                visited[newx] = true;
                dq.addLast(newx);
            }
            
        }
        
        return res;
    }
}