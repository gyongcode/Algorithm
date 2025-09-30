import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3]);
            }
            dp[i]++;
        }

        System.out.println(dp[N]);

        StringBuilder sb = new StringBuilder();
        int i = N;
        while (i > 1) {
            sb.append(i).append(" ");

            if (dp[i - 1] == dp[i] - 1) {
                i--;
                continue;
            }
            if (i % 2 == 0 && dp[i / 2] == dp[i] - 1) {
                i /= 2;
                continue;
            }
            if (i % 3 == 0 && dp[i / 3] == dp[i] - 1) {
                i /= 3;
                continue;
            }
        }
        sb.append(1).append(" ");

        System.out.println(sb);
    }
}
