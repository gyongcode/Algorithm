import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] inputs, dp, lens;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        inputs = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        dp = new int[N + 1];
        dp[0] = -1_000_000_001;
        lens = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            if (dp[index] < inputs[i]) {
                dp[++index] = inputs[i];
                lens[i] = index;
            } else {
                int tmp = binarySearch(0, index, inputs[i]);
                dp[tmp] = inputs[i];
                lens[i] = tmp;
            }
        }

        System.out.println(index);

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int lensIndex = N;
        while (index > 0) {
            if (lens[lensIndex] == index) {
                stack.addLast(inputs[lensIndex]);
                index--;
            }

            lensIndex--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.removeLast()).append(" ");
        }

        System.out.println(sb);
    }


    static int binarySearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

