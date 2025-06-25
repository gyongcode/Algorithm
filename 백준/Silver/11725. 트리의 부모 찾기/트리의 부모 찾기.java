import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static  ArrayList<Integer>[] adj;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        parent = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(){
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.addLast(1);
        parent[1] = 1;

        while(!Q.isEmpty()){
            int cur = Q.removeFirst();

            for (int newX : adj[cur]){
                if(parent[newX] != 0)
                    continue;

                parent[newX] = cur;
                Q.addLast(newX);
            }
        }
    }


}
