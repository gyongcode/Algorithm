import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] adj;
    static ArrayDeque<Integer> Q;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==1){
                    adj[i][j] = 1;
                }
            }
        }
        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(adj[i][j]==Integer.MAX_VALUE)
                    sb.append(0).append(" ");
                else {
                    sb.append(1).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void floydWarshall(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(adj[j][i]==Integer.MAX_VALUE || adj[i][k]==Integer.MAX_VALUE) {
                        continue;
                    }
                    adj[j][k] = Math.min(adj[j][k], adj[j][i] + adj[i][k]);
                }
            }
        }
    }
}