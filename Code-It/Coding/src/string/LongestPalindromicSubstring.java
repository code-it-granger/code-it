package string;

/*
https://medium.com/@bhprtk/longest-palindromic-substring-a8190fab03ff
*/

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "annab";
        System.out.println(lps(s,0,0));
    }
    private static String lps(String s, int start, int end){
        String lps=s.substring(0,1);
        for(int i=0;i<s.length();i++){
            String temp = expand(s,i,i);
            if(temp.length() > lps.length())
                lps=temp;

            temp = expand(s,i,i+1);

            if(temp.length() > lps.length())
                lps = temp;
        }

        return lps;
    }

    private static String expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
