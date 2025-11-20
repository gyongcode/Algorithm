import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] inputs = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = inputs[1];
        if (N > 1) {
            dp[2] = dp[1] + inputs[2];
        }
        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + inputs[i]);
            dp[i] = Math.max(dp[i - 3] + inputs[i - 1] + inputs[i], dp[i]);
        }

        System.out.println(dp[N]);
    }
}

