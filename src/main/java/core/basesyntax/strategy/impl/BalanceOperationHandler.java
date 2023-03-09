package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage = FruitStorage.storage;

    @Override
    public void handleOperation(Transaction transaction) {
        storage.put(transaction.getProductName(), transaction.getQuantity());
    }
}
