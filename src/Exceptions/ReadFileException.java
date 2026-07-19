package Exceptions;

public class ReadFileException extends RuntimeException {

    public ReadFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
