package camusbai.leetcode.source;

import java.util.Set;

/**
 * Created by camusbai on 4/7/2014.
 */
public class StringOperation {
  /**
   * To reverse words in a string without leading or trailing or duplicate spaces
   * @param s - input string
   * @return new string with reversely ordered words
   */
  public static String reverseWords(String s){
    String[] splits = s.split(" ");
    StringBuilder builder = new StringBuilder();
    boolean afterSpace = true;
    for(int i=splits.length-1;i>-1;--i){
      if(!splits[i].isEmpty()) {
        builder.append(splits[i]+" ");
      }
    }

    return builder.toString().trim();
  }


  public static boolean wordBreak(String s, Set<String> dict) {
    return true;
  }

  //utility
  public static void printMatrix(int[][] matrix, int x, int y){
    for(int i=0;i<x;++i){
      for(int j=0;j<y;++j){
        System.out.print((String.valueOf(matrix[i][j])+' '));
      }
      System.out.println();
    }

  }
}

