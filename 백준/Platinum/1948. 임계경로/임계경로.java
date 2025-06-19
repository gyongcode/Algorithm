import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, start, end, cnt;
    static ArrayList<Node>[] adj;
    static ArrayList<Node>[] reverse_adj;
    static int[] visited, indegree;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        reverse_adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            reverse_adj[i] = new ArrayList<>();
        }

        indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            indegree[e]++;
            adj[s].add(new Node(e, w));
            reverse_adj[e].add(new Node(s, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];

        ts();
        reverse_ts();

        System.out.println(visited[end]);
        System.out.println(cnt);
    }

    static void ts() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(start);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (Node node : adj[cur]) {
                int e = node.e;
                int w = node.w;

                visited[e] = Math.max(visited[e], visited[cur] + w);
                indegree[e]--;

                if (indegree[e] == 0) {
                    q.addLast(e);
                }
            }
        }
    }

    static void reverse_ts() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] reverse_visited = new boolean[n + 1];
        reverse_visited[end] = true;
        q.offer(end);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (Node node : reverse_adj[cur]) {
                int e = node.e;
                int w = node.w;

                if (visited[e] + w == visited[cur]) {
                    cnt++;

                    if (reverse_visited[e]) {
                        continue;
                    }
                    reverse_visited[e] = true;
                    q.offer(e);
                }
            }
        }
    }
}

class Node {

    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
}
