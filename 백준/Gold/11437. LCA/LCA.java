import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Node[] tree;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            // 노드 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        tree = new Node[N + 1];
        bfs(1);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = findParent(a, b);
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    static int findParent(int a, int b) {
        Node pa = tree[a];
        Node pb = tree[b];

        while (pa != pb) {
            if (pa.depth == pb.depth) {
                pa = pa.parent;
                pb = pb.parent;
            } else if (pa.depth > pb.depth) {
                pa = pa.parent;
            } else {
                pb = pb.parent;
            }
        }

        return pa.n;
    }

    static void bfs(int n) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(n);
        boolean[] visited = new boolean[N + 1];
        visited[n] = true;
        tree[n] = new Node(n, 0, null);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                q.addLast(next);
                tree[next] = new Node(next, tree[cur].depth + 1, tree[cur]);
            }
        }
    }

}

class Node {

    int n;
    int depth;
    Node parent;

    public Node(int n, int depth, Node parent) {
        this.n = n;
        this.depth = depth;
        this.parent = parent;
    }

}



