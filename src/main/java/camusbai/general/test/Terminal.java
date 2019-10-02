package camusbai.general.test;

/**
 * Created by camusbai on 6/19/2014.
 */
public class Terminal {
  public static void main(String[] args){
    int a=1, b=10;
    int c= foo1(a,b);
    System.out.format("%d %d %d%n",a,b,c);

    fooObj obj1 = new fooObj(1);
    System.out.println(obj1);
    incrementObj(obj1);
    System.out.println(obj1);
  }

  public static int foo1(int a, int b){
    ++a;
    return a;
  }

  public static void incrementObj(fooObj obj1){
    obj1.increment();
  }

  public static class fooObj{
    public int x;
    fooObj(int x) {
      this.x = x;
    }
    public void increment(){
      ++x;
    }

    @Override
    public String toString() {
      return Integer.toString(x);
    }
  }
}

