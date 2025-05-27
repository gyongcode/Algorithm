import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long min, max;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;

            long start_index = min / pow;
            if (min % pow != 0) {
                start_index++;
            }

            for (long j = start_index; j * pow <= max; j++) {
                check[(int) (j * pow - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < (int) (max - min + 1); i++) {
            if (!check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }


}
