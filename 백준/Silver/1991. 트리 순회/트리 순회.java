import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            char root = s[0].charAt(0), L = s[1].charAt(0), R=s[2].charAt(0);

            int p = root-'A';
            if(L!='.'){
                int c = L-'A';
                arr[p][0] = c;
            }else {
                arr[p][0] = -1;
            }

            if(R!='.'){
                int c = R-'A';
                arr[p][1] = c;
            }
            else
                arr[p][1] = -1;
        }

        pre(0);
        sb.append("\n");
        in(0);
        sb.append("\n");
        post(0);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    static void pre(int n){
        sb.append((char) (n+'A'));

        if(arr[n][0]!=-1){
            pre(arr[n][0]);
        }
        if(arr[n][1]!=-1){
            pre(arr[n][1]);
        }
    }

    static void in(int n){
        if(arr[n][0]!=-1){
            in(arr[n][0]);
        }
        sb.append((char) (n+'A'));
        if(arr[n][1]!=-1){
            in(arr[n][1]);
        }
    }

    static void post(int n){
        if(arr[n][0]!=-1){
            post(arr[n][0]);
        }
        if(arr[n][1]!=-1){
            post(arr[n][1]);
        }
        sb.append((char) (n+'A'));
    }

}
