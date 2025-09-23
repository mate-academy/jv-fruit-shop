package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        if (storage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Cannot complete purchase. Not enough "
                    + transaction.getFruit() + " in stock.");
        }
        storage.put(transaction.getFruit(), storage
                .getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
