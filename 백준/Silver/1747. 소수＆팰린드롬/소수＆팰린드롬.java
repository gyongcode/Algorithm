import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A, B;
    static boolean[] isPrime;
    static final int MAX = 1003001;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        getPrime();

        for (int i = N; i <= MAX; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    static void getPrime() {
        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}