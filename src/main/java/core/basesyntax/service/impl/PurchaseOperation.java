package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    private final Map<String, Integer> fruitStorage;

    public PurchaseOperation(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(),
                fruitStorage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
