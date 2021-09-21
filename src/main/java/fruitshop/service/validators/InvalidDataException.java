package fruitshop.service.validators;

public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
