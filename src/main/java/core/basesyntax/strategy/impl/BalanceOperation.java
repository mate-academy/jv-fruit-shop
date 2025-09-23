package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Balance quantity cannot be negative: "
                    + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(),transaction.getQuantity());
    }
}
