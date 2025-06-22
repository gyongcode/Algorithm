import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static long[] dist;
    static Edge[] edges;

    static class Edge {
        int start;
        int end;
        int w;

        public Edge(int s, int e, int w){
            this.start = s;
            this.end = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, w);
        }
        if(!bellmanFord()){
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            if(dist[i]==Integer.MAX_VALUE)
                sb.append(-1).append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    static boolean bellmanFord(){
        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                int s = edges[j].start;
                int e = edges[j].end;
                int w = edges[j].w;
                if(dist[s] ==Integer.MAX_VALUE)
                    continue;
                dist[e] = Math.min(dist[e], dist[s]+w);
            }
        }

        for (int j = 0; j < M; j++) {
            int s = edges[j].start;
            int e = edges[j].end;
            int w = edges[j].w;
            if(dist[s] ==Integer.MAX_VALUE)
                continue;
            if(dist[e] > dist[s]+w){
                return false;
            }
        }
        return true;
    }
}
