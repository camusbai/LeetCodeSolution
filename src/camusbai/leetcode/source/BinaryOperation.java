package camusbai.leetcode.source;

/**
 * Created by camusbai on 5/11/2014.
 */
public class BinaryOperation {
  /*
  * Divide two integers without using multiplication, division and mod operator.
  * */
  public int divide(int dividend, int divisor) {
    boolean sign = (dividend<0&&divisor<0) || (dividend>0&&divisor>0);
    long dvnd = dividend; long dvsr = divisor;
    dvnd = dvnd> 0 ? dvnd : -dvnd;
    dvsr = dvsr> 0 ? dvsr : -dvsr;
    if(divisor==0||dividend==0||dvnd<dvsr) return 0;
    if(dvnd==dvsr) return sign ? 1:-1;
    int cnt=0;
    while(dvsr<=dvnd) {
      dvsr <<= 1; ++cnt;
    }
    dvsr>>=1;
    StringBuilder quotient = new StringBuilder();
    for(int i=0;i<cnt;++i){
      if(dvnd<dvsr){
        quotient.append('0');
      }
      else{
        dvnd-=dvsr;
        quotient.append('1');
      }
      dvsr>>=1;
    }
    long result = Long.parseLong(quotient.toString(),2);
    result = sign ? result:-result;
    return (int) result;
  }

  public static int getDigits(int n){
    int digits=0;
    while((n>>=1)!=0){
      digits++;
    }
    return ++digits;
  }
}
