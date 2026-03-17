package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Objects;

/**
 * PURCHASE operation: subtract purchased quantity with pre-check.
 */
public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        Objects.requireNonNull(transaction);
        Objects.requireNonNull(storage);
        String fruit = transaction.getFruit();
        int current = storage.getOrDefault(fruit, 0);
        int resulting = current - transaction.getQuantity();
        if (resulting < 0) {
            throw new RuntimeException("Purchase leads to negative balance for: " + fruit);
        }
        storage.put(fruit, resulting);
    }
}
