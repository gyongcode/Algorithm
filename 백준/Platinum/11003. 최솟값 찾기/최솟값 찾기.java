import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SgTree sgTree = new SgTree();
        sgTree.setUp(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int start = i - L + 1;
            if (start < 0) {
                start = 0;
            }

            sb.append(sgTree.query(start, i)).append(" ");
        }

        System.out.println(sb);
    }

}


class SgTree {

    int startIndex;
    int[] tree;

    void setUp(int[] arr) {
        startIndex = 1;
        int len = arr.length;
        while (startIndex < len) {
            startIndex *= 2;
        }

        tree = new int[startIndex * 2];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0; i < len; i++) {
            tree[startIndex + i] = arr[i];
        }

        for (int i = startIndex - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    int query(int start, int end) {
        int res = Integer.MAX_VALUE;

        start += startIndex;
        end += startIndex;

        while (start <= end) {
            if (start % 2 == 1) {
                res = Math.min(res, tree[start]);
                start++;
            }

            if (end % 2 == 0) {
                res = Math.min(res, tree[end]);
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return res;
    }
}
