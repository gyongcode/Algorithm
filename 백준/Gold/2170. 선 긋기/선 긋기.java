import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Line> lines;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        long res = 0;
        long start = lines.get(0).start;
        long end = lines.get(0).end;

        for (int i = 1; i < N; i++) {
            Line next = lines.get(i);

            if (end >= next.start) {
                end = Math.max(next.end, end);
            } else {
                res += end - start;
                start = next.start;
                end = next.end;
            }

        }

        res += end - start;
        System.out.println(res);
    }


}

class Line implements Comparable<Line> {

    long start;
    long end;

    public Line(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line o1) {
        int cmp = Long.compare(this.start, o1.start);

        if (cmp == 0) {
            return Long.compare(this.end, o1.end);
        }
        return cmp;
    }
}
