package Applied.PhoneBook;

import java.util.Map;
import java.util.Set;

public final class PhoneBookValidator {

    public static void checkName(String name, Map<String, Set<Integer>> phoneBook){
        if(!phoneBook.containsKey(name)){
            throw new IllegalArgumentException("Такого имени нет в телефонной книге");
        }
    }

    public static void checkNumber(String name, Integer number, Map<String, Set<Integer>> phoneBook){
        if(!phoneBook.get(name).contains(number)){
            throw new IllegalArgumentException("Номер телефона не существует для имени: " + name);
        }
    }
}
