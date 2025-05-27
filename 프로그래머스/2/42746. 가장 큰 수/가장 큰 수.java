import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< numbers.length; i++){
            list.add(numbers[i]);
        }
        
        list.sort((a,b) ->{
            return Integer.parseInt("" + b + a) - Integer.parseInt("" + a + b);
        });
        
        if(list.get(0) == 0)
            return "0";
        String result = "";
        for(int i : list){
            result += i;
        }
        
        return result;
    }
}
// 610 106