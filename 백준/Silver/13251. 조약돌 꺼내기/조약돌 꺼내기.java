import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M, N, K;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());
        cnt = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            N += cnt[i];
        }
        K = Integer.parseInt(br.readLine());

        double res = 0;
        for (int i = 0; i < M; i++) {
            if (cnt[i] < K) {
                continue;
            }
            double cur = 1;
            for (int j = 0; j < K; j++) {
                cur *= (double) (cnt[i] - j) / (N - j);
            }
            res += cur;
        }
        System.out.println(res);
    }


}
