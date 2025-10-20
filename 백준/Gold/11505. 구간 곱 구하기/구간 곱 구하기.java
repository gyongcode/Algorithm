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

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegTree segTree = new SegTree();
        segTree.init(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                segTree.update(b, c);
            } else {
//                sb.append(segTree.query(b, c)).append("\n");
                System.out.println(segTree.query(b, c));
            }
        }

        System.out.println(sb);
    }


}

class SegTree {

    static final int MOD = 1000000007;
    long[] tree;
    int start;

    public void init(int[] arr) {
        start = 1;

        while (start < arr.length) {
            start *= 2;
        }

        tree = new long[start * 2 + 1];

        for (int i = 0; i < arr.length; i++) {
            tree[start + i] = arr[i];
        }

        for (int i = start - 1; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % MOD;
        }
    }

    public void update(int index, int n) {
        int cur_index = start + index - 1;
        tree[cur_index] = n;
        cur_index /= 2;

        while (cur_index >= 1) {
            tree[cur_index] = tree[cur_index * 2] * tree[cur_index * 2 + 1] % MOD;
            cur_index /= 2;
        }

    }

    public long query(int start_index, int end_index) {
        int left = start + start_index - 1;
        int right = start + end_index - 1;

        long res = 1;
        while (left <= right) {
            if (left % 2 == 0) {
                left /= 2;
            } else {
                res *= tree[left];
                res %= MOD;
                left = (left + 1) / 2;
            }

            if (right % 2 == 0) {
                res *= tree[right];
                res %= MOD;
                right = (right - 1) / 2;
            } else {
                right /= 2;
            }
        }

        return res;
    }
}
