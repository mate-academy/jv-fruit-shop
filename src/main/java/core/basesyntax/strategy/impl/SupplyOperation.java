package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Supply quantity cannot be negative: "
                    + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(), storage
                .getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
