package Vgarden.demo.exceptions;

public class CommandeException extends RuntimeException {

    public CommandeException() {

    }

    public CommandeException(String message) {
        super(message);
    }
}
