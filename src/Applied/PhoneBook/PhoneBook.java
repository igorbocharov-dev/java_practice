package Applied.PhoneBook;


import util.Validator;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Реализовать телефонную книгу: класс PhoneBook с методами addNumber(name, number)
 * (у человека может быть несколько номеров, без дублей),
 * getNumbers(name) (пустой список вместо null, наружу копия),
 * removeNumber(name, number) (если номеров не осталось - удалить запись целиком)
 */
public class PhoneBook {

    private final Map<String, Set<Long>> phoneBook = new LinkedHashMap<>();

    public void addNumber(String name, Long number){
        Validator.validateString(name, "Не корректный формат имени");
        Validator.validateLong(number, "Не корректный формат номера");
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(number);
            return;
        }
        Set<Long> phoneNumbers = new LinkedHashSet<>();
        phoneNumbers.add(number);
        phoneBook.put(name, phoneNumbers);
    }

    public Set<Long> getNumbers(String name){
        Validator.validateString(name, "Не корректный формат имени");
        if(!phoneBook.containsKey(name)){
            return Set.of();
        }
        return new LinkedHashSet<>(phoneBook.get(name));
    }

    public void removeNumber(String name, Long number){
        Validator.validateString(name, "Не корректный формат имени");
        Validator.validateLong(number, "Не корректный формат номера");
        PhoneBookValidator.checkName(name, phoneBook);
        if(phoneBook.get(name).isEmpty()){
            phoneBook.remove(name);
            return;
        }
        PhoneBookValidator.checkNumber(name, number, phoneBook);
        phoneBook.get(name).remove(number);
    }

}
