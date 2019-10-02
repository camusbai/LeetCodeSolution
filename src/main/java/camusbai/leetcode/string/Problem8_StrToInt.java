package camusbai.leetcode.string;

  /** String to Integer (atoi)
   *
   * Scenarios to be considered:
   * a) decimal, none, one, more than one decimal point
   * b) negative number
   * c) primitive type int out of bound
   **/
public class Problem8_StrToInt {
    public static int atoi(String str) {
        boolean countStart = false, positive = true, signConfirmed = false;
        int target = 0, digit = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                if (countStart)
                    return target;
            }

            if (Character.isDigit(str.charAt(i)))
                target = target * 10 + str.charAt(i) - '0';
            else if (signConfirmed)
                return target;

            if (str.charAt(i) == '-') {
                positive = false;
                signConfirmed = true;
            } else if (str.charAt(i) == '+') {
                positive = true;
                signConfirmed = true;
            }
        }
        return target;
    }
}
