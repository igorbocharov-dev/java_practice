package Exceptions;

/**
 * Свое исключение ValidationException extends RuntimeException с конструктором (message, cause).
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
