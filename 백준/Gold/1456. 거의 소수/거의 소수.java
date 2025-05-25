import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A, B;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        isPrime = new boolean[10000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < 10000001; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;

        for (int i = 2; i < 10000001; i++) {
            if (isPrime[i]) {

                long tmp = i;
                while ((double) i <= (double) B / (double) tmp) {
                    if ((double) i >= (double) A / (double) tmp) {
                        cnt++;
                    }
                    tmp *= i;
                }
            }
        }

        System.out.println(cnt);
    }

}
