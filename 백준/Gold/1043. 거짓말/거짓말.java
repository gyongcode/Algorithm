import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static HashSet<Integer> know;
    static HashSet<Integer>[] party;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static int visited[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //진실을 아는사람
        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());
        if(knowCount==0){
            System.out.println(M);
            return;
        }
        else{
            know = new HashSet<Integer>();
            for (int i = 0; i < knowCount; i++) {
                know.add(Integer.parseInt(st.nextToken()));
            }
        }
        //System.out.println("know : "+know);
        //파티에 오는 사람
        party = new HashSet[M];
        visited = new int[M];
        for (int i = 0; i < M; i++) {
            party[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int ComeCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < ComeCount; j++) {
                int n = Integer.parseInt(st.nextToken());
                //파티의 인덱스를 큐에 넣음
                if(!Q.contains(i)) {
                    if(know.contains(n)){
                        Q.addLast(i);
                        visited[i] = 1;
                    }
                }
                party[i].add(n);
            }
        }

        bfs();
        int count=0;
        for (int i = 0; i < M; i++) {
            if(visited[i] == 0){
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(){
        while(!Q.isEmpty()){
            int cur = Q.removeFirst();

            //i는 사람 번호
            for(int i : party[cur]){
                for (int j = 0; j < M; j++) {
                    //방문 했으면 넘김
                    if(visited[j] ==1)
                        continue;
                    if(party[j].contains(i)){
                        Q.addLast(j);
                        visited[j] = 1;
                    }
                }
            }
        }
    }
}
