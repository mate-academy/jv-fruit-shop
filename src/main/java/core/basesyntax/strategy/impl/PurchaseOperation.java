package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), storage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
