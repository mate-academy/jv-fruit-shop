package core.basesyntax.stategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitOperationHandler {
    void executeOperation(FruitTransaction fruitTransaction, Map<String, Integer> inventory);

    default void validateQuantity(int quantity, String fruit) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Transaction quantity for "
                    + fruit + " must be greater than 0");
        }
    }
}
