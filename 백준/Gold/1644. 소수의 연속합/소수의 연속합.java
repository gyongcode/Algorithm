import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> primes = get_prime(N);
        int res = 0;
        int sum = primes.get(0);
        int left = 0;
        int right = 0;

        while (right < primes.size()) {
            if (sum == N) {
                res++;
            }

            if (sum >= N) {
                sum -= primes.get(left);
                left++;
            } else if (sum < N) {
                right++;
                if (right >= primes.size()) {
                    break;
                }
                sum += primes.get(right);
            }
        }
        System.out.println(res);
    }


    static ArrayList<Integer> get_prime(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
