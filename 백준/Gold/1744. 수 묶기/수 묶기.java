import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive_dq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> negative_dq = new PriorityQueue<>();
        boolean hasZero = false;

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                hasZero = true;
            } else if (n == 1) {
                sum++;
            } else if (n > 0) {
                positive_dq.offer(n);
            } else {
                negative_dq.offer(n);
            }
        }

        while (!positive_dq.isEmpty()) {
            int a = positive_dq.poll();
            if (positive_dq.isEmpty()) {
                sum += a;
            } else {
                int b = positive_dq.poll();
                sum += a * b;
            }
        }

        while (!negative_dq.isEmpty()) {
            int a = negative_dq.poll();
            if (negative_dq.isEmpty()) {
                if (!hasZero) {
                    sum += a;
                }
            } else {
                int b = negative_dq.poll();
                sum += a * b;
            }
        }

        System.out.println(sum);
    }
}

