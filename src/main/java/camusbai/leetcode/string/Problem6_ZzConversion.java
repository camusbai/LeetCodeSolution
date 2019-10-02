package camusbai.leetcode.string;

/*
    * 6. ZigZag Conversion
    *
    * For details, refer to https://leetcode.com/problems/zigzag-conversion/
    *
    **/
public class Problem6_ZzConversion {

    public static void main(String[] args) {
        String zigzag = "PAYPALISHIRING";
        System.out.println(convert(zigzag, 14));
    }


    public static String convert(String s, int nRows) {
        if (nRows < 2 || nRows >= s.length())
            return s;
        StringBuilder builder = new StringBuilder();
        int chunk = (s.length() + nRows - 2) / (nRows - 1); // plus divisor minus one to dividend so always round up
        for (int i = 0; i < nRows; ++i) {
            for (int j = 0; j < chunk; ++j) {
                try {
                    if (j % 2 == 0) {
                        if (i != nRows - 1)
                            builder.append(s.charAt(j * (nRows - 1) + i));
                    } else {
                        if (i != 0)
                            builder.append(s.charAt((j + 1) * (nRows - 1) - i));
                    }
                } catch (IndexOutOfBoundsException ex) {
                    // catch out of bound scenarios and keep looping
                }
            }
        }
        return builder.toString();
    }
}
