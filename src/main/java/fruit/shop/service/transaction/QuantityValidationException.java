package fruit.shop.service.transaction;

public class QuantityValidationException extends RuntimeException {
    public QuantityValidationException(String message) {
        super(message);
    }
}
