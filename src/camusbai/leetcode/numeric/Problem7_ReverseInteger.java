package camusbai.leetcode.numeric;

/*
 * Reverse Integer
 * */
public class Problem7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Reverse integer: " + reverse(-2147483641));
        System.out.println("Reverse integer: " + reverse(2002));
    }
    public static int reverse(int x) {
        int rvse = 0, bit=0;
        while (x != 0) {
            if(++bit==10)
                if(rvse*10/10!=rvse)
                    return 0;
            rvse = rvse * 10 + x % 10;
            x /= 10;
        }
        return x < 0 ? -rvse : rvse;
    }
}
