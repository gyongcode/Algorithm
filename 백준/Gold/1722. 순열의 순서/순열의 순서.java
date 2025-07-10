import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        long[] F = new long[N + 1];
        F[0] = 1;
        for (int i = 1; i < N + 1; i++) {
            F[i] = F[i - 1] * i;
        }
        boolean[] visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());

        if (p == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i < N + 1; i++) {
                int cnt = 1;
                for (int j = 1; j < N + 1; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (k <= F[N - i] * cnt) {
                        System.out.print(j + " ");
                        visited[j] = true;
                        k -= F[N - i] * (cnt - 1);
                        break;
                    }
                    cnt++;
                }
            }
        } else {
            long k = 1;
            int[] S = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                int cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    cnt++;
                }
                k += cnt * F[N - i];
                visited[S[i]] = true;
            }
            System.out.println(k);
        }
    }
}
