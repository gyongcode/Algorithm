import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}, dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            // 1 현재 위치 2 목적지

            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            System.out.println(bfs(start_x, start_y, end_x, end_y));
        }

    }

    static int bfs(int x, int y, int end_x, int end_y) {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.addLast(new int[]{x, y, 0});
        visited = new boolean[N][N];
        visited[x][y] = true;

        while (!Q.isEmpty()) {
            int[] cur = Q.removeFirst();

            for (int i = 0; i < 8; i++) {
                int newx = cur[0] + dx[i];
                int newy = cur[1] + dy[i];
                int newd = cur[2] + 1;

                if (newx < 0 || newx >= N || newy < 0 || newy >= N || visited[newx][newy]) {
                    continue;
                }
                if (newx == end_x && newy == end_y) {
                    return newd;
                }
                Q.addLast(new int[]{newx, newy, newd});
                visited[newx][newy] = true;
            }
        }

        return 0;
    }

}

