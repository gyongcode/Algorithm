import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] dist;
    static ArrayList<Integer> trace = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100_001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        bfs();

        System.out.println(dist[K]);
        get_trace(K);
    }

    static void get_trace(int cur) {
        if (dist[cur] == 0) {
            System.out.print(cur + " ");
            return;
        }

        int prev = cur;
        if (cur + 1 < 100001 && dist[cur] == dist[cur + 1] + 1) {
            prev += 1;
        } else if (cur - 1 >= 0 && dist[cur] == dist[cur - 1] + 1) {
            prev -= 1;
        } else if (cur % 2 == 0 && dist[cur] == dist[cur / 2] + 1) {
            prev /= 2;
        }
        get_trace(prev);

        System.out.print(cur + " ");
    }

    static void bfs() {
        ArrayDeque<Integer> pq = new ArrayDeque<>();
        dist[N] = 0;
        pq.add(N);

        while (!pq.isEmpty()) {
            int cur = pq.removeFirst();
            if (cur == K) {
                return;
            }

            if (cur + 1 < 100001 && dist[cur + 1] == Integer.MAX_VALUE) {
                dist[cur + 1] = dist[cur] + 1;
                pq.addLast(cur + 1);
            }

            if (cur - 1 >= 0 && dist[cur - 1] == Integer.MAX_VALUE) {
                dist[cur - 1] = dist[cur] + 1;
                pq.addLast(cur - 1);
            }

            if (cur * 2 < 100_001 && dist[cur * 2] == Integer.MAX_VALUE) {
                dist[cur * 2] = dist[cur] + 1;
                pq.addLast(cur * 2);
            }
        }
    }

}
