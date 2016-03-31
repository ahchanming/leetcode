/**
 * Created by chanming on 16/3/29.
 */

public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i){
            if (i == 0 || i == numRows - 1){
                int step = numRows * 2 - 2;
                int now = i;
                while (now < s.length()){
                    sb.append(s.charAt(now));
                    now += step;
                }
            }else{
                int step1 = (numRows - i - 1 ) * 2;
                int step2 = i * 2;
                int now = i;
                while (now < s.length()){
                    sb.append(s.charAt(now));
                    now += step1;
                    if (now < s.length()){
                        sb.append(s.charAt(now));
                        now += step2;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Problem6().convert("ABCDEF", 2));
    }
}
