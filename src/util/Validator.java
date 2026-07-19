package util;

import java.time.LocalDate;

public final class Validator {

    public static void validateString(String s, String message){
        if(s == null || s.isBlank()){
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateLong(Long number, String message){
        if(number == null || number <= 0){
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateLocalDate(LocalDate date, String message){
        if(date == null || date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException(message);
        }
    }
}
