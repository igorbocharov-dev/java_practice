package Applied;

import Applied.SiteStats.SiteStats;
import Applied.WireHouse.Warehouse;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.receive("T", 10L);
        warehouse.receive("C", 10L);
        warehouse.receive("A", 10L);
        warehouse.receive("B", 10L);

        System.out.println(warehouse.ship("A", 8L));
        System.out.println(warehouse.ship("A", 8L));

        System.out.println(warehouse.printStock());
    }

    /**
     * Метод maskPhone(String phone) - скрыть середину номера: видны первые 5 символов и последние 4,
     * между ними три звездочки. Если строка короче 9 символов - вернуть как есть
     */
    public static String maskPhone(String phone){
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Не корректный формат номера");
        }
        if(phone.length() < 9){
            return phone;
        }
        String firstFiveChars = phone.substring(0, 5);
        String lastFourChars = phone.substring(8, 12);
        return firstFiveChars + "***" + lastFourChars;
    }


    /**
     * Сборка отчета из 100 000 строк двумя способами: метод joinWithPlus (через += в цикле)
     * и joinWithBuilder (через StringBuilder.append). Замерь время каждого через System.currentTimeMillis и сравни
     */
    public static long joinWithPlus(){
        long timeBefore = System.currentTimeMillis();
        String s = "string";
        for (int i = 0; i < 100_000; i++) {
            s += "string";
        }
        long timeAfter = System.currentTimeMillis();
        return timeAfter - timeBefore;
    }

    public static long joinWithBuilder(){
        long timeBefore = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("string");
        for (int i = 0; i < 100_000; i++) {
            s.append("string");
        }
        long timeAfter = System.currentTimeMillis();
        return timeAfter - timeBefore;
    }

}
