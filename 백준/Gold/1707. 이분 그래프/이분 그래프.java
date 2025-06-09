import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K, V, E;
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            for (int j = 0; j < V + 1; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            visited = new int[V + 1];
            boolean flag = true;
            for (int j = 1; j < V + 1; j++) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    if (!dfs(j)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean dfs(int n) {
        for (Integer next : adj[n]) {
            if (visited[next] == 0) {
                if (visited[n] == 1) {
                    visited[next] = 2;
                } else {
                    visited[next] = 1;
                }

                if (!dfs(next)) {
                    return false;
                }
            } else if (visited[n] == visited[next]) {
                return false;
            }
        }
        return true;
    }
}