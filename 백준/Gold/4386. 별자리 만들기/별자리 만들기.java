import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static double[][] points;
    static PriorityQueue<Edge> pq;
    static int[] parents;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        points = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        System.out.println(mst());
    }

    static double mst() {
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double v = getDist(points[i], points[j]);
                pq.add(new Edge(i, j, v));
            }
        }

        double res = 0;
        int cnt = 0;
        while (!pq.isEmpty() && cnt < n - 1) {
            Edge e = pq.remove();
            if (union(e.s, e.e)) {
                res += e.v;
                cnt++;
            }
        }

        return res;
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
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


    static double getDist(double[] A, double[] B) {
        return Math.sqrt(Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2));
    }
}

class Edge implements Comparable<Edge> {

    int s;
    int e;
    double v;

    public Edge(int s, int e, double v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o1) {
        return (int) (this.v - o1.v);
    }
}

