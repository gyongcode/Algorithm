import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long cnt = n;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt = cnt - cnt / i;

                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            cnt = cnt - cnt / n;
        }

        System.out.println(cnt);
    }
}
