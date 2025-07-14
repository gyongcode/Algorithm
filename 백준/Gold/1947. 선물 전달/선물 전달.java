import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[N + 1];
        dp[2] = 1;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (i - 1) * ((dp[i - 1] + dp[i - 2]) % MOD) % MOD;
        }

        System.out.println(dp[N]);
    }
}