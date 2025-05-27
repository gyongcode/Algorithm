import java.util.*;

class Solution {
    static HashSet<Integer>[] sets;
    
    public int solution(int N, int number) {
        sets = new HashSet[9];
        
        for(int i=0; i<9; i++){
            sets[i] = new HashSet<>();
        }
        
        if(number == N)
            return 1;
        sets[1].add(N);
        
        for(int i=2; i<9; i++){
            int tmp = 0;
            for(int j=0; j<i; j++)
                tmp = tmp*10 + N;
            sets[i].add(tmp);
            
            for(int j = 1; j<i; j++){
                for(int k : sets[j]){
                    for(int m : sets[i-j]){
                        sets[i].add(k*m);
                        sets[i].add(k+m);
                        sets[i].add(k-m);
                        if(m != 0)
                            sets[i].add(k/m);
                    }
                }
            }
            
            if(sets[i].contains(number))
                return i;
        }
        
        return -1;
    }
    
}

/*
5

55, 1 (5/ 5) , 10 (5+5), 0 (5-5), 25  (5*5)
*/