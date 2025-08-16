import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, M;
    static int[] arr;
    static HashSet<Integer>[] adj;
    static int[] indgree;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            adj = new HashSet[N + 1];
            for (int j = 0; j < N + 1; j++) {
                adj[j] = new HashSet<>();
            }
            indgree = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp = 0;
            arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                indgree[arr[j]] = j;
                for (int k = 0; k < j; k++) {
                    adj[arr[k]].add(arr[j]);
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a].contains(b)) {
                    adj[a].remove(b);
                    adj[b].add(a);
                    indgree[b]--;
                    indgree[a]++;
                } else {
                    adj[b].remove(a);
                    adj[a].add(b);
                    indgree[a]--;
                    indgree[b]++;
                }
            }

            System.out.println(ts());
        }


    }

    // 하나로 게속 유지가 된다면 출력
    // 위상 정렬을 돌렸을 떄 큐에 2개 이상이 있다면 ?
    // 위상 정렬이 순환되거나 중간에 끝기면 IMPOSSIBLE

    static String ts() {
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indgree[i] == 0) {
                Q.addLast(i);
            }
        }

        while (!Q.isEmpty()) {
            if (Q.size() > 1) {
                return "?";
            }

            int cur = Q.removeFirst();
            sb.append(cur).append(" ");

            for (int next : adj[cur]) {
                if (--indgree[next] == 0) {
                    Q.addLast(next);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (indgree[i] != 0) {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }


}

