import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, size;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[][] parents;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];
        int tmp = 1;
        while (tmp <= N) {
            tmp <<= 1;
            size++;
        }
        parents = new int[size + 1][N + 1];
        bfs();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }
    }

    private static int excuteLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = size; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parents[i][b]]) {
                    b = parents[i][b];
                }
            }
        }

        for (int i = size; i >= 0; i--) {
            if (parents[i][a] != parents[i][b]) {
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        int LCA = a;
        if (a != b) {
            LCA = parents[0][LCA];
        }

        return LCA;
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque();
        q.addLast(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.removeFirst();

            for (Integer next : tree[now]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.addLast(next);
                parents[0][next] = now;
                depth[next] = depth[now] + 1;
            }
        }
    }
}
