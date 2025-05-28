class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        
        int mid = Math.max(yellow / 2, 1);
        
        for(int h=1; h<= mid; h++){
            if(yellow % h != 0)
                continue;
            
            int w = yellow / h;
            
            int cur_cnt = (h + w) * 2  +4;
            if(cur_cnt == brown){
                result[0] = w+2;
                result[1] = h+2;
                break;
            }
        }
        
        return result;
    }
    
    
}