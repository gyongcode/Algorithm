import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        MaxSgTree maxSgTree = new MaxSgTree();
        maxSgTree.setUp(inputs, N);
        MinSgTree minSgTree = new MinSgTree();
        minSgTree.setUp(inputs, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.printf("%d %d\n", minSgTree.query(start, end), maxSgTree.query(start, end));
        }

    }
}

interface SgTree {

    public void setUp(int[] arr, int len);

    public int query(int start, int end);
}

class MaxSgTree implements SgTree {

    int[] tree;
    int startIndex;

    public void setUp(int[] arr, int len) {
        startIndex = 1;

        while (startIndex < len) {
            startIndex *= 2;
        }

        tree = new int[startIndex * 2 + 1];
        Arrays.fill(tree, Integer.MIN_VALUE);

        for (int i = 0; i < len; i++) {
            int curIndex = startIndex + i;

            while (curIndex > 0 && arr[i] > tree[curIndex]) {
                tree[curIndex] = arr[i];
                curIndex /= 2;
            }
        }
    }


    public int query(int start, int end) {
        int left = startIndex + start - 1;
        int right = startIndex + end - 1;

        int res = Integer.MIN_VALUE;

        while (left <= right) {
            if (left % 2 == 0) {
                left /= 2;
            } else {
                res = Math.max(res, tree[left]);
                left = (left + 1) / 2;
            }

            if (right % 2 == 1) {
                right /= 2;
            } else {
                res = Math.max(res, tree[right]);
                right = (right - 1) / 2;
            }
        }

        return res;
    }
}

class MinSgTree implements SgTree {

    int[] tree;
    int startIndex;

    @Override
    public void setUp(int[] arr, int len) {
        startIndex = 1;

        while (startIndex < len) {
            startIndex *= 2;
        }

        tree = new int[startIndex * 2 + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0; i < len; i++) {
            int curIndex = startIndex + i;

            while (curIndex > 0 && arr[i] < tree[curIndex]) {
                tree[curIndex] = arr[i];
                curIndex /= 2;
            }
        }
    }

    @Override
    public int query(int start, int end) {
        int left = startIndex + start - 1;
        int right = startIndex + end - 1;

        int res = Integer.MAX_VALUE;

        while (left <= right) {
            if (left % 2 == 0) {
                left /= 2;
            } else {
                res = Math.min(res, tree[left]);
                left = (left + 1) / 2;
            }

            if (right % 2 == 1) {
                right /= 2;
            } else {
                res = Math.min(res, tree[right]);
                right = (right - 1) / 2;
            }
        }

        return res;
    }
}
