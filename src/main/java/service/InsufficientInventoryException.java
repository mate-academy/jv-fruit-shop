package service;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(String message) {
        super(message);
    }
}
