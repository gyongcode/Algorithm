import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static long[] sumArr, arr;
    static HashMap<Long, Long> changes;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        sumArr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
            sumArr[i] = arr[i] + sumArr[i - 1];
        }

        // 1 변경, 2 구간합 출력
        StringBuilder sb = new StringBuilder();

        changes = new HashMap<>();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changes.put(b, c - arr[(int) b]);
            }
            if (a == 2) {
                long tmp = sumArr[(int) c] - sumArr[(int) b - 1];
                for (long key : changes.keySet()) {
                    if (key >= b && key <= c) {
                        tmp += changes.get(key);
                    }
                }
                sb.append(tmp).append("\n");
            }
        }

        System.out.println(sb);
    }

}



