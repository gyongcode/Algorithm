import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, n, m, t, s, g, h;
    static ArrayDeque<Node>[] adj;
    static TreeSet<Integer> set;
    static int[] dist;
    static boolean[] isPatheds;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayDeque[n + 1];
            for (int j = 0; j < n + 1; j++) {
                adj[j] = new ArrayDeque<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
            }

            set = new TreeSet<>();
            for (int j = 0; j < t; j++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);

            for (int j : set) {
                if (isPatheds[j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }


    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        pq.offer(new Node(start, 0));
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        isPatheds = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d > dist[cur.b]) {
                continue;
            }

            for (Node next : adj[cur.b]) {
                int next_dist = next.d + cur.d;
                boolean flag =
                    cur.isPathed || (cur.b == g && next.b == h) || (cur.b == h && next.b == g);

                if (next_dist < dist[next.b]) {
                    pq.add(new Node(next.b, next_dist, flag));
                    isPatheds[next.b] = flag;
                    dist[next.b] = next_dist;
                } else if (next_dist == dist[next.b] && !isPatheds[next.b] && flag) {
                    pq.add(new Node(next.b, next_dist, flag));
                    isPatheds[next.b] = flag;
                    dist[next.b] = next_dist;
                }
            }
        }
    }
}


class Node {

    int b;
    int d;
    boolean isPathed = false;

    public Node(int b, int d) {
        this.b = b;
        this.d = d;
    }

    public Node(int b, int d, boolean bb) {
        this.b = b;
        this.d = d;
        this.isPathed = bb;
    }
}
