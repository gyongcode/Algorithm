import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(get_area());
        }

    }


    public static long get_area() {
        long max = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && arr[stack.getLast()] >= arr[i]) {
                long height = arr[stack.removeLast()];
                long width = stack.isEmpty() ? i : (i - 1 - stack.getLast());

                max = Math.max(max, height * width);
            }

            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            long height = arr[stack.removeLast()];
            long width = stack.isEmpty() ? N : (N - 1 - stack.getLast());

            max = Math.max(max, height * width);
        }

        return max;
    }


}
