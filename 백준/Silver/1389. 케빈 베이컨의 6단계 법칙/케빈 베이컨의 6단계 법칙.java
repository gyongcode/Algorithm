import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            dist[n1][n2] = 1;
            dist[n2][n1] = 1;
        }

        floydWarshall();
        int min = Integer.MAX_VALUE, num=-1;
        for (int i = 1; i < N+1; i++) {
            int sum = 0;
            for (int j = 1; j < N+1; j++) {
                sum += dist[i][j];
            }
            if(sum<min){
                min = sum;
                num = i;
            }
        }
        System.out.println(num);
    }

    static public void floydWarshall(){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    if(dist[j][i]==Integer.MAX_VALUE || dist[i][k]==Integer.MAX_VALUE)
                        continue;
                    dist[j][k] = Math.min(dist[j][i]+dist[i][k], dist[j][k]);
                }
            }
        }
    }
}