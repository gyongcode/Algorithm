import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(get_area(0, N - 1));
        }

    }


    public static long get_area(int l, int h) {
        if (l == h) {
            return arr[l];
        }

        int mid = (l + h) / 2;

        long leftArea = get_area(l, mid);
        long rightArea = get_area(mid + 1, h);
        long midArea = get_midArea(l, h, mid);

        return Math.max(leftArea, Math.max(rightArea, midArea));
    }

    public static long get_midArea(int l, int h, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = arr[mid];
        long maxArea = arr[mid];

        while (toLeft > l && toRight < h) {
            if (arr[toLeft - 1] < arr[toRight + 1]) {
                toRight++;
                height = Math.min(height, arr[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, arr[toLeft]);
            }

            maxArea = Math.max(maxArea, (toRight - toLeft + 1) * height);
        }

        while (toRight < h) {
            toRight++;
            height = Math.min(height, arr[toRight]);

            maxArea = Math.max(maxArea, (toRight - toLeft + 1) * height);
        }

        while (toLeft > l) {
            toLeft--;
            height = Math.min(height, arr[toLeft]);

            maxArea = Math.max(maxArea, (toRight - toLeft + 1) * height);
        }

        return maxArea;
    }

}
