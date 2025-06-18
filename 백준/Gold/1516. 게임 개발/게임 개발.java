import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] indegree, visited, time;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        indegree = new int[N + 1];
        visited = new int[N + 1];
        time = new int[N + 1];

        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }
                indegree[i]++;
                adj[n].add(i);
            }
        }

        ts();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void ts() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.addLast(i);
                visited[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (int next : adj[cur]) {
                indegree[next]--;
                visited[next] = Math.max(visited[cur], visited[next]);

                if (indegree[next] == 0) {
                    q.addLast(next);
                    visited[next] += time[next];
                }
            }
        }
    }
}
