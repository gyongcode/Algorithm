import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;
    static int N;
    static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                int w = get_dist(c);
                if (w == 0) {
                    continue;
                }
                edges.add(new Edge(i, j, w));
            }
        }

        Collections.sort(edges);

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        int sum = 0;
        for (Edge edge : edges) {
            if (cnt < N - 1) {
                if (union(edge.s, edge.e)) {
                    cnt++;
                } else {
                    sum += edge.w;
                }
            } else {
                sum += edge.w;
            }
        }

        if (cnt < N - 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (pa > pb) {
            parents[pa] = pb;
        } else {
            parents[pb] = pa;
        }

        return true;
    }

    static int get_dist(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 27;
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        }
        return 0;
    }

}

class Edge implements Comparable<Edge> {

    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}