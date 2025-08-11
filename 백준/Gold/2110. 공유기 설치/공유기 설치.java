import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr[N - 1] - arr[0];
        int max = 0;

        while (low <= high) {
            int mid = (high + low) / 2;
//            System.out.printf("high : %d\nlow: %d\nmid : %d\n", high, low, mid);

            int cnt = find(mid);

            if (cnt >= C) {
                low = mid + 1;
                max = mid;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(max);
    }

    static int find(int x) {
        int tmp = arr[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - tmp >= x) {
                cnt++;
                tmp = arr[i];
            }
        }
        return cnt;
    }
}
