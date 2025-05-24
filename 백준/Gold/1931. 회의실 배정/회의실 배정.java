import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static class Node implements Comparable<Node>{
        int strat;
        int end;

        Node(int strat, int end){
            this.strat = strat;
            this.end = end;
        }

        @Override
        public int compareTo(Node o){
            if(this.end == o.end){
                return this.strat - o.strat;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int strat = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.add(new Node(strat, end));
        }

        Collections.sort(nodes);

        int n = 0;
        int cnt = 0;
        for (Node node : nodes) {
            if(n <= node.strat){
                n = node.end;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
