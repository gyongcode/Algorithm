import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(N, mid / i);
            }

            if (cnt >= M) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(result);

    }
}
