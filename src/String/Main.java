package String;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * Метод isPalindrome(String s) - палиндром без учета регистра и пробелов. "А роза упала на лапу Азора" дает true.
     */

    public static boolean isPalindrome(String s){
        String normalizedString = s.toLowerCase().trim().replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder();
        String str = stringBuilder.append(normalizedString).toString();
        String reverseStr = stringBuilder.reverse().toString();
        return str.equals(reverseStr);
    }

    /**
     * Метод countChars(String s) - countChars("hello") дает {h=1, e=1, l=2, o=1}
     */

    public static Map<Character, Integer> countChars(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        char [] chars = s.toCharArray();
        for (Character aChar : chars) {
            int count = 1;
            map.merge(aChar, count, Integer::sum);
        }
        return map;
    }
}
