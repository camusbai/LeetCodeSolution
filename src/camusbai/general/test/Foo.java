package camusbai.general.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by camusbai on 8/29/2014.
 */
public class Foo {
  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    System.out.println(Arrays.toString(arr));
    System.out.println(arr.length);

    int i ;
    for(i =0 ;i <=10;++i) {
      System.out.println(i);
    }
    System.out.println("For loop finished");
    System.out.println(i);

    Queue<Character> q = new LinkedList<Character>();


  }

  public void test(){}
}
