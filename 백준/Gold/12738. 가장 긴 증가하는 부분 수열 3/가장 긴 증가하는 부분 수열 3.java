import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        inputs = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = -1_000_000_001;
        int len = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dp[len] < inputs[i]) {
                dp[++len] = inputs[i];
            } else {
                int index = binarySearch(0, len, inputs[i]);
                dp[index] = inputs[i];
            }
        }

        System.out.println(len);
    }


    static int binarySearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
