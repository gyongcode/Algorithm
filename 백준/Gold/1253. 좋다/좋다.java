import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (find(arr, i)) {
                res++;
            }
        }

        System.out.println(res);

    }

    static boolean find(int[] arr, int index) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (left == index) {
                left++;
                continue;
            }
            if (right == index) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == arr[index]) {
                return true;
            } else if (sum > arr[index]) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}

