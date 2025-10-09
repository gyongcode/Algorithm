import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer> list;
    static boolean[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        selected = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (selected[i]) {
                continue;
            }

            list.add(i);
            selected[i] = true;
            dfs(depth + 1);
            list.remove(list.size() - 1);
            selected[i] = false;
        }
    }

}
