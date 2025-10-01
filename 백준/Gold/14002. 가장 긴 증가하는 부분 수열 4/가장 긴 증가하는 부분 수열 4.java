import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs, dp;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        inputs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        int end = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (inputs[i] <= inputs[j]) {
                    continue;
                }

                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            if (dp[end] < dp[i]) {
                end = i;
            }
        }

        System.out.println(dp[end]);
        ArrayList<Integer> result = new ArrayList<>();
        while (end > 0) {
            result.add(inputs[end]);

            int tmp = end - 1;
            while (dp[tmp] != dp[end] - 1) {
                tmp--;
            }
            end = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
