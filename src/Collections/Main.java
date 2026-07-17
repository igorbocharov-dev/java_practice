package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(wordFrequency("один, два, два, три, три три четыре четыре четыре четыре пять пять пять пять пять шесть шесть шесть шесть шесть шесть "));
    }

    /**
     * Метод removeDuplicates(List list) - убрать дубликаты,
     * сохранив порядок первых вхождений. [3, 1, 3, 2, 1] дает [3, 1, 2]
     */
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().toList();
    }

    /**
     * Метод mergeSorted(List a, List b) - слить два отсортированных списка в один отсортированный
     */
    public static <T> List<T> mergeSorted(List<T> list1, List<T> list2) {
        List<T> merge = new ArrayList<>(list1);
        merge.addAll(list2);
        return merge.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Метод wordFrequency(String text) - вывести топ-3 самых частых слова в строке
     */
    public static Set<String> wordFrequency(String text) {
        String[] words = text.split(" |, ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            int count = 1;
            map.merge(word, count, Integer::sum);
        }
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
