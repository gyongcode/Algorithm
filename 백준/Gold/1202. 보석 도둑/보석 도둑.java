import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] M, V, C;
    static ArrayList<Node> list= new ArrayList<>();

    static class Node implements Comparable<Node>{
        int weight;
        int value;

        Node(int w, int v){
            this.weight = w;
            this.value = v;
        }

        @Override
        public int compareTo(Node o1){
            if(o1.weight == this.weight)
                return o1.value-this.value;
            return this.weight - o1.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(w, v));
        }

        C = new int[K];
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(C);
        Collections.sort(list);

        long result = 0;
        int index = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; i++) {
            int cur_weight = C[i];

            while(index < N && list.get(index).weight<= cur_weight){
                pq.offer(list.get(index++).value);
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }


        System.out.println(result);
    }

}