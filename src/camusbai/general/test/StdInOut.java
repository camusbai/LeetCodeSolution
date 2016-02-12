package camusbai.general.test;

import java.util.Scanner;

/**
 * Created by camusbai on 2/11/2016.
 */
public class StdInOut {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    int sum = 0;
    while (x-- != 0) {
      sum+=sc.nextInt();
    }
    System.out.println(Integer.toString(sum));
  }
}
