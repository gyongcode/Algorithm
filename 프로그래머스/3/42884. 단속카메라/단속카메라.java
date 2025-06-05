import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        ArrayList<Node> list = new ArrayList<>();
        
        for(int[] route : routes){
            list.add(new Node(route[0], route[1]));
        }
        
        Collections.sort(list);
        
        int cnt = 0;
        int tmp = -40000;
            
        for(Node cur : list){
            if(cur.start > tmp){
                cnt++;
                tmp = cur.end;
            }
        }
        
        return cnt;
    }
}

class Node implements Comparable<Node>{
    int start;
    int end;
    
    public Node(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Node o1){
        
        return this.end == o1.end ? this.start-o1.start : this.end - o1.end;
    }
}

//[-30, 30], [-20,-15], [-18,-13], [-14,-5], [-5,-3]]	