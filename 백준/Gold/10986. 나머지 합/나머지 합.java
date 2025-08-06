import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long cnt = 0;
        int[] C = new int[M];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken()) % M;

            if (i == 0) {
                sum = n;
            } else {
                sum = (sum + n) % M;
            }

            if (sum == 0) {
                cnt++;
            }
            C[sum]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                cnt += (long) C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(cnt);
    }

}
