import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, total, result;
    static int[][] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }
        result = Integer.MAX_VALUE;
        selected = new boolean[N];
        dfs(0, 0);

        System.out.println(result);
    }


    static void dfs(int depth, int start) {
        if (depth >= N / 2) {
            result = Math.min(result, getPoint());
            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    static int getPoint() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) {
                    sum1 += arr[i][j];
                }
                if (!selected[i] && !selected[j]) {
                    sum2 += arr[i][j];
                }
            }
        }

        return Math.abs(sum1 - sum2);
    }
}
