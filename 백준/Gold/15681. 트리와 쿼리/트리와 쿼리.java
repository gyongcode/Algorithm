import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, R, Q;
    static ArrayList<Integer>[] adj, tree;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        tree = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        parent = new int[N+1];
        size = new int[N+1];

        makeTree(R, -1);
        countSubtreeNodes(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(size[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void makeTree(int curNode, int p){
        for (int c : adj[curNode]){
            if(c!=p){
                tree[curNode].add(c);
                parent[c] = curNode;
                makeTree(c, curNode);
            }
        }
    }

    static void countSubtreeNodes(int curNode){
        size[curNode] = 1;

        for (int c : tree[curNode]){
            countSubtreeNodes(c);
            size[curNode] += size[c];
        }
    }
}
