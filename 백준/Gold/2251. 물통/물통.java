import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] bottles_size;
    static HashSet<String> set = new HashSet<>();
    static TreeSet<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        bottles_size = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        bottles_size[0] = Integer.parseInt(st.nextToken());
        bottles_size[1] = Integer.parseInt(st.nextToken());
        bottles_size[2] = Integer.parseInt(st.nextToken());

        bfs();

        for (int i : result) {
            System.out.printf("%d ", i);
        }
    }

    static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0, 0, bottles_size[2]});
        result.add(bottles_size[2]);
        set.add("0/0/" + bottles_size[2]);

        while (!dq.isEmpty()) {
            int[] bottles = dq.removeFirst();
//            System.out.println(Arrays.toString(bottles));

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j || bottles[i] == 0 || bottles[j] == bottles_size[j]) {
                        continue;
                    }

                    int[] tmp = move(bottles, i, j);

                    if (tmp[0] == 0 && !result.contains(tmp[2])) {
                        result.add(tmp[2]);
                    }

                    String s = tmp[0] + "/" + tmp[1] + "/" + tmp[2];
                    if (!set.contains(s)) {
                        dq.addLast(tmp);
                        set.add(s);
                    }
                }
            }
        }
    }

    static int[] move(int[] bottles, int a, int b) {
        int[] res = new int[3];

        res[b] = bottles[b] + bottles[a];
        if (res[b] > bottles_size[b]) {
            res[a] = res[b] - bottles_size[b];
            res[b] = bottles_size[b];
        } else {
            res[a] = 0;
        }
        res[3 - a - b] = bottles[3 - a - b];
        return res;
    }
}
