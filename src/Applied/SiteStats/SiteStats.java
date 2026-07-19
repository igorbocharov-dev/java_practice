package Applied.SiteStats;

import util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Статистика посещений сайта: класс SiteStats с методами visit(LocalDate date, String userId),
 * uniqueVisitors(date) (сколько разных пользователей за день), wasUserOn(date, userId)
 */
public class SiteStats {

    private final Map<LocalDate, List<String>> siteStats = new HashMap<>();

    private List<String> users;

    public void visit(LocalDate date, String userId){
        Validator.validateLocalDate(date, "Не корректный формат даты");
        Validator.validateString(userId, "Не корректный id пользователя");
        if(!siteStats.containsKey(date)){
            users = new ArrayList<>();
            users.add(userId);
            siteStats.put(date, users);
            return;
        }
        users.add(userId);
        siteStats.put(date, users);
    }

    public long uniqueVisitors(LocalDate date){
        Validator.validateLocalDate(date, "Не корректный формат даты");
        return siteStats.get(date).stream().distinct().count();
    }

    public boolean wasUserOn(LocalDate date, String userId){
        Validator.validateLocalDate(date, "Не корректный формат даты");
        Validator.validateString(userId, "Не корректный id пользователя");
        return siteStats.get(date).contains(userId);
    }
}
