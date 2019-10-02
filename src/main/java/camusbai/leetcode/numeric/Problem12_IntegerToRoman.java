package camusbai.leetcode.numeric;

/**
 * Input is guaranteed to be within the range from 1 to 3999
 *
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1,000
 */
public class Problem12_IntegerToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(3999));
  }

  public static String intToRoman(int num) {
    int units = num % 10;
    int tens = num / 10 % 10;
    int hund = num / 100 % 10;
    int thou = num / 1000;

    StringBuilder roman = new StringBuilder();
    for(int i=0;i<thou;++i)
      roman.append("M");

    roman.append(getRomanDigit(hund,"M","D","C"));
    roman.append(getRomanDigit(tens,"C","L","X"));
    roman.append(getRomanDigit(units,"X","V","I"));

    return roman.toString();
  }

  /**
   * Get Roman presentation of digit
   *
   * String tens can be "X", "C", "M"
   * String five can be "V", "L", "D"
   * String one can be "I", "X", "C"
   * */
  private static String getRomanDigit(int digit, String tens, String five, String one){
    StringBuilder roman = new StringBuilder();
    int x= digit - 5;
    if(x==-5)
      return "";
    else if(x>-5&&x<-1)
      for(int i=0;i<x+5;++i)
        roman.append(one);
    else if(x==-1)
      return one+five;
    else if(x==0)
      return five;
    else if(x>0&&x<4) {
      roman.append(five);
      for (int i = 0; i < x; ++i)
        roman.append(one);
    }
    else if(x==4)
      roman.append(one+tens);

    return roman.toString();
  }
}
