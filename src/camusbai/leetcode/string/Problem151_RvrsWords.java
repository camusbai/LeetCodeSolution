package camusbai.leetcode.string;

/**
 * 151. Reverse Words in a String
 * <p/>
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class Problem151_RvrsWords {


    public static void main(String[] args) {
        //String input = "Yo~ Lin, you are  awesome!!";
        String input = "the sky is blue";
        String output = reverseWords(input);
        System.out.println(output);
    }

    public static String reverseWords(String s) {
        String[] splits = s.split(" ");
        StringBuilder builder = new StringBuilder();
        boolean afterSpace = true;
        for (int i = splits.length - 1; i > -1; --i) {
            if (!splits[i].isEmpty()) {
                builder.append(splits[i] + " ");
            }
        }
        return builder.toString().trim();
    }
}
