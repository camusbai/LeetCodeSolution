package camusbai.leetcode.arraylist;

import java.util.*;

public class Problem763_ParitionLabels {
    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";

        new Problem763_ParitionLabels().partitionLabels(input);
    }

    public List<Integer> partitionLabels(String S) {
        if(S==null || S.length()==0){
            return Arrays.asList(0);
        } else if(S.length()==1){
            return Arrays.asList(1);
        }

        Map<Character, Integer> count = new HashMap<>();
        int[] occurrenceToRight = new int[S.length()];

        for(int i=S.length()-1;i>-1;i--){
            Character c = S.charAt(i);
            count.put(c, count.getOrDefault(c, -1)+1);
            occurrenceToRight[i] = count.get(c);
        }

        List<Integer> result = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        int leftBound = -1;
        for(int i=0;i<S.length();i++){
            Character c = S.charAt(i);

            if(occurrenceToRight[i]==0){
                visited.remove(c);
                if(visited.isEmpty()){
                    result.add(i-leftBound);
                    leftBound = i;
                }
            } else{
                visited.add(c);
            }
        }

        return result;
    }
}
