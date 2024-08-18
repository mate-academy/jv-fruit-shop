package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    private final Map<String, Integer> storage;

    public BalanceOperation(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
        storage.put(transaction.getFruit(), quantity);
    }
}
