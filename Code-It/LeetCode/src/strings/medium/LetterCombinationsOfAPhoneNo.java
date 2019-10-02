package strings.medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNo {
   static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "2abc");
        put("3", "3def");
        put("4", "4ghi");
        put("5", "5jkl");
        put("6", "6mno");
        put("7", "7pqrs");
        put("8", "8tuv");
        put("9", "9wxyz");
        put("(","(");
        put("-","-");
        put(")",")");
    }};
    public static void main(String[] args) {

        String phoneNo = "23";
        combinations("",phoneNo);
        System.out.println(result);

    }

    static List<String> result = new ArrayList<>();

    private static void combinations(String combo, String nextDigits){
        if(nextDigits.length()==0) {
            result.add(combo);
            return;
        }

        String firstDigit = nextDigits.substring(0,1);
        String letters = phone.get(firstDigit);

        for(int i=0;i<letters.length();i++){
            String letter = phone.get(firstDigit).substring(i,i+1);
            if(letter.equals("(") || letter.equals(")") || letter.equals("-")) {
                combo += letter;
                combinations(combo, nextDigits.substring(1));
            }
            else{
                combinations(combo+letter, nextDigits.substring(1));
            }
        }

    }
}
