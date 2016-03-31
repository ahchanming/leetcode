/**
 * Created by chanming on 16/3/29.
 */

public class Problem5 {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() == 0){
            return "";
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); ++i){
            //odd
            int j = 1;
            while (i - j >= 0 && i + j < s.length()){
                if (s.charAt(i - j) == s.charAt(i + j)){
                    j++;
                }else{
                    break;
                }
            }
            j--;
            if (j * 2 + 1 > result.length()){
                result = s.substring(i - j, i + j + 1);
            }
            //even
            j = 0;
            while (i - 1 - j >= 0 && i + j < s.length()){
                if (s.charAt(i - 1 - j) == s.charAt(i + j)){
                    j++;
                }else{
                    break;
                }
            }
            j--;
            if (j >= 0 && j * 2 + 2 > result.length()){
                result = s.substring(i - j - 1, i + j + 1);
            }
        }
        return result;
    }

    public  static void main(String args[]){
        System.out.println( new Problem5().longestPalindrome("aabccccbaadaabccc"));
    }
}
