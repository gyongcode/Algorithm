import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, W;
    static int[][] WS;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        WS = new int[W + 1][2];
        for (int i = 1; i < W + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            WS[i][0] = Integer.parseInt(st.nextToken());
            WS[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[W + 1][W + 1];

        System.out.println(dfs(1, 0, 0));

        int one = 0;
        int two = 0;
        for (int i = 1; i < W + 1; i++) {
            int dist = get_dist(1, one, i);

            if (dp[one][two] - dist == dp[i][two]) {
                one = i;
                System.out.println(1);
            } else {
                two = i;
                System.out.println(2);
            }
        }
    }

    static int dfs(int e, int one, int two) {
        if (e > W) {
            return 0;
        }

        if (dp[one][two] != 0) {
            return dp[one][two];
        }

        int first = dfs(e + 1, e, two) + get_dist(1, one, e);
        int second = dfs(e + 1, one, e) + get_dist(2, two, e);

        return dp[one][two] = Math.min(first, second);
    }

    private static int get_dist(int type, int s, int e) {
        int[] start = WS[s];
        int[] end = WS[e];

        if (s == 0) {
            if (type == 1) {
                start = new int[]{1, 1};
            } else {
                start = new int[]{N, N};
            }
        }

        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }


}
