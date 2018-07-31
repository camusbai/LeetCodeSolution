package camusbai.oa;

public class SubArraySum {
    public static void subArraySum(int[] input, int target) {
        int sum = 0, start = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];

            if (sum > target) {
                while (sum > target && start < i) {
                    sum -= input[start++];
                }
            }

            if (sum == target) {
                System.out.println(start + "," + i);
                return;
            }
        }
        System.out.println("cannot find");
    }

    public static void main(String[] args) {
        subArraySum(new int[]{1, 1, 1, 99}, 102);
    }
}
