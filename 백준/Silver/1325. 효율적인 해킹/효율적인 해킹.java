import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        answer = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (answer[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int x) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(x);
        visited[x] = true;
        answer[x]++;

        while (!dq.isEmpty()) {
            int cur = dq.removeFirst();
            for (Integer next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                answer[x]++;
                dq.addLast(next);
            }
        }

        max = Math.max(answer[x], max);
    }
}