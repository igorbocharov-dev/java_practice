package Exceptions;

import util.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Метод safeParse(String s), который возвращает Optional вместо исключения. (Integer.parseInt() но без исключения)
     */
    public Optional<Integer> safeParse(String s){
        Validator.validateString(s, "Значение 's' не должно быть пустым");
        final Optional<Integer> result;
        try {
            result = Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        return result;
    }

    /**
     * Реализовать метод parseAge(String) ловит NumberFormatException и пробрасывает ValidationException с причиной
     */
    public Integer parseAge(String age){
        Validator.validateString(age, "Значение 'age' не должно быть пустым");
        final Integer result;
        try {
            result = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new ValidationException("Не корректный формат значения age: " + age, e.getCause());
        }
        return result;
    }

    /**
     * Посчитать непустые строки текстового файла. (Метод принимает путь к файлу)
     */
    public long countOfNonEmptyLines(String URI){
        Validator.validateString(URI, "Путь к файлу не может быть пустым");
        final Path path = Paths.get(URI);
        final List<String> allLines;
        try {
            allLines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ReadFileException("Ошибка при чтении строк файла, путь: " + URI, e.getCause());
        }
        return allLines.stream().filter(line -> !line.isBlank()).count();
    }
}
