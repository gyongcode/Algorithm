import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;
    static ArrayList<Integer>[] adj;
    static int delete;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
                continue;
            }
            adj[i].add(n);
            adj[n].add(i);
        }

        delete = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        dfs(root);

        System.out.println(cnt);
    }

    static void dfs(int n) {
        if (n == delete) {
            return;
        }
        visited[n] = true;

        boolean flag = true;
        for (int i : adj[n]) {
            if (i == delete) {
                continue;
            }
            if (!visited[i]) {
                dfs(i);
                flag = false;
            }
        }

        if (flag) {
            cnt++;
        }
    }


}

