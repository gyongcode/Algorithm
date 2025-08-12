import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            M = Integer.parseInt(br.readLine());

            sb.append((M + 1) / 2);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                int n = Integer.parseInt(st.nextToken());
                pq.add(n);

                if (j % 2 == 0) {
                    if (cnt % 10 == 0) {
                        cnt = 0;
                        sb.append("\n");
                    }

                    int mid = j / 2 + 1;
                    for (int k = 0; k < mid; k++) {
                        q.addLast(pq.poll());
                    }

//                    System.out.printf("[mid] : %d", mid);
//                    System.out.print("[Q] : ");
//                    System.out.println(q);

                    for (int k = 0; k < mid; k++) {
                        if (k == mid - 1) {
                            sb.append(q.getFirst()).append(" ");
                        }
                        pq.add(q.removeFirst());
                    }
                    cnt++;
                }
//                System.out.println(pq);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}

