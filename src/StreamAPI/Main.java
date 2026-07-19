package StreamAPI;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Реализовать метод, который находит сумму всех четных чисел списка.
     */
    public static int sumOfAllEvenNumbers(List<Integer> list){
        return list.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
    }

    /**
     * Реализовать метод, который принимает список и отдает список имен в верхнем регистре.
     */
    public static List<String> nameToUpperCase(List<String> list){
        return list.stream().map(String::toUpperCase).toList();
    }

    /**
     * Реализовать метод, который возвращает кол-во строк в списке длиннее n символов.
     */
    public static long numberOfStringsWithCharsLength(List<String> list, int lengthChars){
        return list.stream().filter(str -> str.length() > lengthChars).count();
    }

}
