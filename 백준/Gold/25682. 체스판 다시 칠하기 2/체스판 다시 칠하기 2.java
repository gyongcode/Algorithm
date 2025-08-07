import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        boolean color = false; // false 면 블랙이 와야함

        for (int i = 1; i < N + 1; i++) {
            String input = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                char c = input.charAt(j - 1);

                if (!color && c == 'W') {
                    map[i][j] = 1;
                } else if (color && c == 'B') {
                    map[i][j] = 1;
                }

                color = !color;
            }

            if (M % 2 == 0) {
                color = !color;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                map[i][j] += (map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1]);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = K; i < N + 1; i++) {
            for (int j = K; j < M + 1; j++) {
                int tmp = map[i][j] - (map[i - K][j] + map[i][j - K] - map[i - K][j - K]);
                min = Math.min(tmp, min);
                max = Math.max(tmp, max);
            }
        }

        System.out.println(Math.min(min, K * K - max));
    }

}
