package fruit.shop.service;

public class InvalidTransactionInputException extends RuntimeException {
    public InvalidTransactionInputException(String message) {
        super("Invalid input. " + message);
    }
}
