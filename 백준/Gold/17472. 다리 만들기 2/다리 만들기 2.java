import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;
    static int N, M;
    static int[][] map;
    static int island_cnt;
    static ArrayList<int[]> islands;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static ArrayList<Bridge> bridges;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        islands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    findIsland(i, j);
                }
            }
        }

        bridges = new ArrayList<>();
        findAllBridges();

        Collections.sort(bridges);

        parents = new int[island_cnt + 1];
        for (int i = 0; i < island_cnt + 1; i++) {
            parents[i] = i;
        }
        int cnt = 0;
        int sum = 0;
        for (Bridge bridge : bridges) {
            if (union(bridge.a, bridge.b)) {
                sum += bridge.w;
                cnt++;
            }
            if (cnt >= island_cnt - 1) {
                System.out.println(sum);
                return;
            }
        }

        System.out.println(-1);
    }

    static void findAllBridges() {
        int[][] minBridge = new int[island_cnt + 1][island_cnt + 1];
        for (int i = 0; i <= island_cnt; i++) {
            Arrays.fill(minBridge[i], Integer.MAX_VALUE);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) {
                    int currentIsland = map[r][c];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dx[d];
                        int nc = c + dy[d];
                        int bridgeLength = 0;

                        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (map[nr][nc]
                                == currentIsland) {
                                break;
                            }
                            if (map[nr][nc] == 0) {
                                bridgeLength++;
                            } else {
                                int targetIsland = map[nr][nc];
                                if (bridgeLength >= 2) {
                                    minBridge[currentIsland][targetIsland] = Math.min(
                                        minBridge[currentIsland][targetIsland], bridgeLength);
                                    minBridge[targetIsland][currentIsland] = Math.min(
                                        minBridge[targetIsland][currentIsland],
                                        bridgeLength);
                                }
                                break;
                            }
                            nr += dx[d];
                            nc += dy[d];
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= island_cnt; i++) {
            for (int j = i + 1; j <= island_cnt; j++) {
                if (minBridge[i][j] != Integer.MAX_VALUE) {
                    bridges.add(new Bridge(i, j, minBridge[i][j]));
                }
            }
        }
    }


    static void findIsland(int start_x, int start_y) {
        islands.add(new int[]{start_x, start_y});
        island_cnt++;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{start_x, start_y});
        visited[start_x][start_y] = true;
        map[start_x][start_y] = island_cnt;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int cur_x = cur[0];
            int cur_y = cur[1];

            for (int i = 0; i < 4; i++) {
                int new_x = cur_x + dx[i];
                int new_y = cur_y + dy[i];

                if (new_x < 0 || new_x >= N || new_y < 0 || new_y >= M || visited[new_x][new_y]
                    || map[new_x][new_y] == 0) {
                    continue;
                }

                q.addLast(new int[]{new_x, new_y});
                map[new_x][new_y] = island_cnt;
                visited[new_x][new_y] = true;
            }
        }

    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (pa > pb) {
            parents[pa] = pb;
        } else {
            parents[pb] = pa;
        }

        return true;
    }

}

class Bridge implements Comparable<Bridge> {

    int a;
    int b;
    int w;

    public Bridge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Bridge b1) {
        return this.w - b1.w;
    }
}