package Applied.WireHouse;

import java.util.Map;

public final class WarehouseValidator {

    public static void checkItemName(String name, Map<String, Long> wireHouse){
        if(!wireHouse.containsKey(name)){
            throw new IllegalArgumentException("Такой позиции на складе нет");
        }
    }

}
