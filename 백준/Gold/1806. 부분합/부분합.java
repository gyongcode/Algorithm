import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int left = 0;
        int right = 1;
        int res = Integer.MAX_VALUE;

        while (right < N + 1) {
            int sum = arr[right] - arr[left];
            if (sum >= S) {
                res = Math.min(res, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
