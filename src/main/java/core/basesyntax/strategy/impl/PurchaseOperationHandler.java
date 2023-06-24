package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage = FruitStorage.storage;

    @Override
    public void handleOperation(FruitTransaction transaction) {
        if (!storage.containsKey(transaction.getProductName())
                || storage.get(transaction.getProductName()) < transaction.getQuantity()) {
            throw new RuntimeException("Can't handle PURCHASE transaction for the '"
                    + transaction.getProductName() + "' with value '" + transaction.getQuantity()
                    + "'. Available quantity is: "
                    + (storage.getOrDefault(transaction.getProductName(), 0)));
        }
        storage.put(transaction.getProductName(),
                storage.get(transaction.getProductName()) - transaction.getQuantity());
    }
}
