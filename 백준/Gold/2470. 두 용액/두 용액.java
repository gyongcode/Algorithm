import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long C;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted()
            .toArray();

        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int min_left = -1, min_right = -1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                min_left = left;
                min_right = right;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.printf("%d %d", arr[min_left], arr[min_right]);
    }
}
