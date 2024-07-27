package core.basesyntax.service.operation;

public interface OperationHandler {
    int getQuantity(int defaultQuantity, int fruitQuantity);

    default void validateQuantity(int defaultQuantity, int fruitQuantity) {
        if (defaultQuantity < 0 || fruitQuantity < 0) {
            throw new RuntimeException("Quantity can't be less than 0");
        }
    }
}
