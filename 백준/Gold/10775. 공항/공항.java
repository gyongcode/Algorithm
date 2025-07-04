import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int G, P;
    static int[] arr, parents;

    public static void main(String[] args) throws IOException {
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parents = new int[G+1];
        for (int i = 1; i < G+1; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int tmp = find(g);

            if(tmp == 0){
                break;
            }

            cnt++;
            union(tmp, tmp-1);
        }

        System.out.println(cnt);
    }

    static int find(int a){
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb)
            parents[pa] = pb;
    }
}