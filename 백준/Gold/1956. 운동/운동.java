import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static int[][] dist;
    static final int INF = 40_000_000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];
        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[s][e] = w;
        }

        fw();

        int result = INF;

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j || dist[i][j] == INF || dist[j][i] == INF) {
                    continue;
                }
                result = Math.min(result, dist[i][j] + dist[j][i]);
            }
        }

        if (result == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    static void fw() {
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                for (int k = 1; k < V + 1; k++) {
                    if (dist[j][i] == INF || dist[i][k] == INF) {
                        continue;
                    }

                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
    }

}
