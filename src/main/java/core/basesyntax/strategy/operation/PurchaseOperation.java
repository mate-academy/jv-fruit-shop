package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        String fruitFromStorage = fruit.getName();
        Integer amountBefore = Storage.storage.get(fruitFromStorage);
        if (amountBefore == null || amountBefore < fruit.getAmount()) {
            throw new RuntimeException("Something is wrong with amount");
        }
        Integer amountAfter = amountBefore - fruit.getAmount();
        Storage.storage.put(fruitFromStorage, amountAfter);
    }
}
