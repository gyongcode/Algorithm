import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast().value > cur) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, cur));

            if (dq.peekFirst().index < i - L + 1) {
                dq.removeFirst();
            }

            sb.append(dq.peekFirst().value).append(" ");
        }

        System.out.println(sb);
    }

}

class Node {

    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

}