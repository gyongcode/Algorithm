import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] D = new int[201][201];
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                    if (D[i][j] > 1000000000) {
                        D[i][j] = 1000000001;
                    }
                }
            }
        }

        if (D[N + M][M] < K) {
            System.out.println(-1);
            return;
        }

        while (!(N == 0 && M == 0)) {
            if (D[N - 1 + M][M] >= K) {
                System.out.print("a");
                N--;
            } else {
                System.out.print("z");
                K = K - D[N - 1 + M][M];
                M--;
            }
        }
    }
}
