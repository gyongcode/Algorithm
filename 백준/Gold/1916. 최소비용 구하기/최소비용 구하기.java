import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] dist;

    static class Node implements Comparable<Node>{
        int end;
        int w;

        Node(int end, int w){
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node o1){
            return this.w-o1.w;
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(a, b));
    }



    static public int dijkstra(int x, int y){
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        dist[x] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curx = cur.end;
            int curd = cur.w;

            if(curd > dist[curx])
                continue;

            for (Node new_node : adj[curx]) {
                int newx = new_node.end;
                int newd = new_node.w+curd;
                if(newd < dist[newx]){
                    pq.offer(new Node(newx, newd));
                    dist[newx] = newd;
                }
            }

        }

        return dist[y];
    }
}
