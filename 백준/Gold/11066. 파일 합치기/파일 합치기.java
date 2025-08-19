import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] dp = new int[N + 1][N + 1];
            int[] sum = new int[N + 1];
            for (int j = 1; j < N + 1; j++) {
                sum[j] = Integer.parseInt(st.nextToken());
                sum[j] += sum[j - 1];
            }

            for (int len = 1; len < N + 1; len++) {
                for (int start = 1; start + len < N + 1; start++) {
                    int end = start + len;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}
