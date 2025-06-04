class Solution {

    public int solution(String name) {
        int result = 0;    
        int len = name.length();
        
        int move = len -1;
        for(int i=0; i<len; i++){
            result += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
                
            move = Math.min(move, i * 2 + len - next);  // 앞으로 쭉갔다가 반대로 돌아가는 경우
            move = Math.min(move, (len - next) * 2 + i);  // 뒤로 쭉갔다고 앞으로 돌아오는 경우
        }
        
        return result + move; 
    }
}