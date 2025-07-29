import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A, B;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long gcd = get_gcd(A, B);

        System.out.println(A * B / gcd);
    }


    static long get_gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return get_gcd(b, a % b);
    }
}
