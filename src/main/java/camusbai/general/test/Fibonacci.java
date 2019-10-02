package camusbai.general.test;

/**
 * Created by camusbai on 2/23/2016.
 */
public class Fibonacci {
  public int fibonacci(int n) {
    int[] cache = new int[n+1];
    return fib(n,cache);
  }

  public int fib(int n, int[] cache) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    if(cache[n]!=0)
      return cache[n];
    else{
      int result = fib(n - 1, cache) + fib(n - 2, cache);
      cache[n] = result;
      return  result;
    }
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    for(int i =0;i<100;i++)
      System.out.println(i+": "+fib.fibonacci(i));
  }
}
