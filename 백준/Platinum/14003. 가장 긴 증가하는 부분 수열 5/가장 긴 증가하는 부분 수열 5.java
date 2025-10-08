import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs, lis, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        inputs = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        lis = new int[N + 1];
        lis[0] = -1_000_000_001;
        int len = 0;
        for (int i = 1; i < N + 1; i++) {

            if (inputs[i] > lis[len]) {
                lis[++len] = inputs[i];
                dp[i] = len;
            } else {
                int idx = binarySearch(0, len, inputs[i]);
                lis[idx] = inputs[i];
                dp[i] = idx;

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");

        List<Integer> result = new ArrayList<>();
        for (int i = N; i > 0; i--) {
            if (dp[i] == len) {
                result.add(inputs[i]);
                len--;
            }
        }
        Collections.reverse(result);
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static int binarySearch(int left, int right, int key) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
