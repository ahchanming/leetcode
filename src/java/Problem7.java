/**
 * Created by chanming on 16/3/29.
 */

public class Problem7 {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0){
            negative = true;
            x = -x;
        }
        Long result = 0L;
        while (x > 0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (negative){
            if (result * -1 < Integer.MIN_VALUE){
                return 0;
            }
            return result.intValue() * -1;
        }else{
            if (result > Integer.MAX_VALUE){
                return 0;
            }
            return result.intValue();
        }
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(new Problem7().reverse(1534236469));
    }
}
