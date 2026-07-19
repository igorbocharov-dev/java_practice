package Exceptions;

/**
 * Класс ManagedResource implements AutoCloseable: конструктор печатает "open имя", close() печатает "close имя"
 */
public class ManagedResource implements AutoCloseable{

    private final String name;

    public ManagedResource(String name){
        this.name = name;
        System.out.println("open " + this.name);
    }

    @Override
    public void close() throws Exception {
        System.out.println("close " + this.name);
    }
}
