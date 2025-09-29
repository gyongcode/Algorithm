import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp = new int[N][N];

            solve(0, N - 1, true);
            System.out.println(dp[0][N - 1]);
        }


    }

    static int solve(int left, int right, boolean flag) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }

        if (flag) {
            return dp[left][right] = Math.max(arr[left] + solve(left + 1, right, false),
                arr[right] + solve(left, right - 1, false));
        } else {
            return dp[left][right] = Math.min(solve(left + 1, right, true),
                solve(left, right - 1, true));
        }
    }
}
