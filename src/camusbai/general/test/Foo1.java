package camusbai.general.test;

/**
 * Created by camusbai on 8/29/2014.
 */
public class Foo1 extends Foo implements MyInterface {

  public String myMethod() {
    return null;
  }

  public static void main(String[] args){
    Foo1 foo1 = new Foo1();
    System.out.println(foo1.myfield);
  }
}
