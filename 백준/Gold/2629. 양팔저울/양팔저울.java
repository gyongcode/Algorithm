import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] beads, weights;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        M = Integer.parseInt(br.readLine());
        beads = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        set = new HashSet<>();
        for (int weight : weights) {

            HashSet<Integer> tmp = new HashSet<>();

            for (int i : set) {
                tmp.add(i + weight);
                tmp.add(Math.abs(i - weight));
            }
            set.addAll(tmp);

            set.add(weight);
        }

        for (int bead : beads) {
            if (set.contains(bead)) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }


}
