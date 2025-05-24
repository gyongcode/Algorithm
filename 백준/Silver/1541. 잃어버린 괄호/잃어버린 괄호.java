import java.awt.image.VolatileImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        boolean flag = false; //false 면 +
        int sum=0;

        StringTokenizer plus = new StringTokenizer(st.nextToken(), "+");
        while(plus.hasMoreTokens()){
            sum += Integer.parseInt(plus.nextToken());
        }

        while(st.hasMoreTokens()){
            StringTokenizer minus = new StringTokenizer(st.nextToken(), "+");
            while(minus.hasMoreTokens()){
                sum -= Integer.parseInt(minus.nextToken());
            }
        }

        System.out.println(sum);
    }

}
