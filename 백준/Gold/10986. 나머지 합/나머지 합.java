import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
        }

        long res = 0;
        long[] cnt = new long[M];

        for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 0) {
                res++;
            }
            cnt[arr[i]]++;
        }

        for (long i : cnt) {
            if (i >= 2) {
                res += i * (i - 1) / 2;
            }
        }

        System.out.println(res);
    }
}

