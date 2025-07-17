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
    static int[] dp;
    static ArrayDeque<Integer> Q;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }

    static int bfs(){
        Q = new ArrayDeque<>();
        Q.add(N);
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        dp[N] = 0;

        while(!Q.isEmpty()){
            int cur = Q.removeFirst();
            if(cur==1)
                return dp[cur];
            for (int i = 1; i <= 3; i++) {
                int newx;
                if(i==1){
                    newx = cur-1;
                }
                else{
                    if(cur%i!=0){
                        continue;
                    }
                    newx = cur/i;
                }
                if(dp[newx]==-1){
                    Q.addLast(newx);
                    dp[newx] = dp[cur]+1;
                }
            }
        }
        return -1;
    }

}