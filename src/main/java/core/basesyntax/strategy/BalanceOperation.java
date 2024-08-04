package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;

import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
        storage.put(transaction.getFruit(), quantity);
    }
}
