import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        int max = 0;

        for (int i = 1; i < N + 1; i++) {
            if (i + input[i][0] - 1 <= N) {
                dp[i + input[i][0] - 1] = Math.max(dp[i + input[i][0] - 1],
                    dp[i - 1] + input[i][1]);
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[N]);
    }
}