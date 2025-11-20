import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int sum = 0;

                if(i!=0 && j!=0){
                    sum+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
                }
                else if(i!=0){
                    sum+=arr[i-1][j];
                }
                else if(j!=0){
                    sum+=arr[i][j-1];
                }

                arr[i][j] = Integer.parseInt(st.nextToken())+sum;
            }
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            String [] range = br.readLine().split(" ");
            int x1 = Integer.parseInt(range[0])-1;
            int y1 = Integer.parseInt(range[1])-1;
            int x2 = Integer.parseInt(range[2])-1;
            int y2 = Integer.parseInt(range[3])-1;

            int minus = 0;
            if(y1!=0&&x1!=0){
                minus += arr[x2][y1-1]+arr[x1-1][y2]-arr[x1-1][y1-1];
            }
            else if(y1!=0){
                minus += arr[x2][y1-1];
            }
            else if(x1!=0){
                minus += arr[x1-1][y2];
            }
            sb.append(arr[x2][y2]-minus ).append("\n");
        }

        System.out.println(sb.toString());
    }
}
