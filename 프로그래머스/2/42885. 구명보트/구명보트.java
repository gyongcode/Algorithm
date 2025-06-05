import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        
        int right = people.length-1;
        int left = 0;        
        
        while(left < right){
            int sum = people[left] + people[right];
            if(sum > limit){
                right--;
                cnt++;
            }
            else{
                cnt++;
                right--;
                left++;
            }
        }
        
        if(left == right)
            cnt++;
        
        return cnt;
    }
}