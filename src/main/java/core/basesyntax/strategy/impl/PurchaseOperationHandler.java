package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage = FruitStorage.storage;

    @Override
    public void handleOperation(Transaction transaction) {
        String productName = transaction.getProductName();
        int quantity = transaction.getQuantity();
        storage.put(productName, storage.containsKey(productName)
                ? storage.get(productName) - quantity
                : -quantity);
    }
}
