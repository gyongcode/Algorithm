import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }


    static boolean dfs(int cur) {
        if (cur >= 81) {
            return true;
        }

        int x = cur / 9;
        int y = cur % 9;

        if (map[x][y] != 0) {
            if (dfs(cur + 1)) {
                return true;
            }
        } else {

            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    if (dfs(cur + 1)) {
                        return true;
                    }
                    map[x][y] = 0;
                }
            }
            return false;
        }

        return false;
    }

    static boolean check(int x, int y, int n) {
        int dx = x / 3;
        int dy = y / 3;

        for (int i = 3 * dx; i < 3 * dx + 3; i++) {
            for (int j = 3 * dy; j < 3 * dy + 3; j++) {
                if (map[i][j] == n) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == n || map[i][y] == n) {
                return false;
            }
        }

        return true;
    }

}
