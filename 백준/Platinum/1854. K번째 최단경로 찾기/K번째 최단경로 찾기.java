import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static ArrayList<Node>[] adj;
    static PriorityQueue<Integer>[] distQ;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        distQ = new PriorityQueue[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            distQ[i] = new PriorityQueue<>((a, b) ->
                b - a);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
        }

        dijkstra();
        StringBuilder sb = new StringBuilder(0);

        for (int i = 1; i < n + 1; i++) {
            if (distQ[i].size() < k) {
                sb.append(-1);
            } else {
                sb.append(distQ[i].peek());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distQ[1].add(0);

        while (!pq.isEmpty()) {
            Node cur_node = pq.poll();
            int cur_x = cur_node.e;
            int cur_w = cur_node.w;

            for (Node next : adj[cur_x]) {
                int next_x = next.e;
                int next_w = next.w + cur_w;

                if (distQ[next_x].size() < k) {
                    distQ[next_x].offer(next_w);
                    pq.offer(new Node(next_x, next_w));
                } else if (distQ[next_x].peek() >= next_w) {
                    distQ[next_x].poll();
                    distQ[next_x].offer(next_w);
                    pq.offer(new Node(next_x, next_w));
                }
            }
        }
    }


}

class Node implements Comparable<Node> {

    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}