package Applied.WireHouse;

import util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Склад: класс Warehouse с методами receive(name, qty), ship(name, qty)
 * (вернуть false, если на складе не хватает), printStock() - остатки в алфавитном порядке
 */
public class Warehouse {

    private final Map<String, Long> warehouse = new HashMap<>();

    public void receive(String name, Long qty){
        Validator.validateString(name, "Не верный формат названия позиции");
        warehouse.merge(name, qty, Long::sum);
    }

    public boolean ship(String name, Long qty){
        Validator.validateString(name, "Не верный формат названия позиции");
        WarehouseValidator.checkItemName(name, warehouse);
        final Long currentValue = warehouse.get(name);
        warehouse.replace(name, currentValue, currentValue - qty);
        final Long newValue = warehouse.get(name);
        return newValue >= 0;
    }

    public Map<String, Long> printStock(){
        return warehouse.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        HashMap::new
                ));
    }
}
