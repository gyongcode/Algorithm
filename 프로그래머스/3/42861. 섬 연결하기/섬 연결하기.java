import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<Edge> edges = new ArrayList<>();
        for(int[] cost : costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges);
        
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        int cnt = 0;
        int index = 0;
        
        while(cnt < n-1){
            Edge cur = edges.get(index);
            if(union(cur.start, cur.end)){
                answer += cur.dist;
                cnt++;
            }
            
            index++;
        }
        
        return answer;
    }
    
    static int find(int a){
        if(parents[a] == a)
            return a;
        
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb)
            return false;
        
        if(pa> pb){
            parents[pa] = pb;
        }else{
            parents[pb] = pa;
        }
        return true;   
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int dist;
    
    public Edge(int start, int end, int dist){
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.dist - o.dist;
    }
}