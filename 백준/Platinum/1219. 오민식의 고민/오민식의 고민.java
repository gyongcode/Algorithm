import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int start, end, N, M;
    static ArrayList<Edge> edges;
    static int[] income;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, w));
        }

        income = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            income[i] = Integer.parseInt(st.nextToken());
        }

        bf();

        if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
            return;
        }

        if (dist[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
            return;
        }

        System.out.println(dist[end]);
    }

    static void bf() {
        dist = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[start] = income[start];
        for (int i = 0; i < N + 50; i++) {
            for (Edge edge : edges) {
                if (dist[edge.s] == Long.MIN_VALUE) {
                    continue;
                } else if (dist[edge.s] == Long.MAX_VALUE) {
                    dist[edge.e] = Long.MAX_VALUE;
                } else if (dist[edge.e] < dist[edge.s] - edge.w + income[edge.e]) {
                    dist[edge.e] = dist[edge.s] - edge.w + income[edge.e];

                    if (i >= N) {
                        dist[edge.e] = Long.MAX_VALUE;
                    }
                }

            }
        }
    }

}

/// 3, 5

class Edge {

    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}