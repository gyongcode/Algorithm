import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SgTree sgTree = new SgTree();
        sgTree.setUp();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                sgTree.changeValue(b, c);
            } else if (a == 2) {
                sb.append(sgTree.getValue(b, (int) c)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class SgTree {

        long[] tree;
        int size = 1;

        public void setUp() {
            while (size < N) {
                size *= 2;
            }

            int startIndex = size;
            tree = new long[size * 2];
            for (int i = 0; i < N; i++) {
                int index = startIndex + i;

                while (index > 0) {
                    tree[index] += arr[i];
                    index /= 2;
                }
            }
        }

        public long getValue(int start, int end) {
            int startIndex = size + start - 1;
            int endIndex = size + end - 1;

            long sum = 0;
            while (startIndex <= endIndex) {
                if (startIndex == endIndex) {
                    sum += tree[startIndex];
                    return sum;
                }

                if (startIndex % 2 == 0) {
                    startIndex /= 2;
                } else {
                    sum += tree[startIndex];
                    startIndex = (startIndex + 1) / 2;
                }

                if (endIndex % 2 == 0) {
                    sum += tree[endIndex];
                    endIndex = (endIndex - 1) / 2;
                } else {
                    endIndex /= 2;
                }
            }

            return sum;
        }

        public void changeValue(int n, long v) {
            int treeIndex = size + n - 1;
            long diff = v - tree[treeIndex];

            while (treeIndex > 0) {
                tree[treeIndex] += diff;

                treeIndex /= 2;
            }
        }

    }
}


