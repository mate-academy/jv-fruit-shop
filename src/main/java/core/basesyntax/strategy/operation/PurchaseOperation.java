package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruit) {
        String fruitFromStorage = fruit.getName();
        Integer amountBefore = Storage.storage.get(fruitFromStorage);
        if (amountBefore == null) {
            throw new RuntimeException(fruit.getName() + " is finished.");
        }
        if (amountBefore < fruit.getAmount()) {
            throw new RuntimeException("We have run out of "
                    + fruit.getName() + ". Only "
                    + amountBefore + " amount is left.");
        }
        Integer amountAfter = amountBefore - fruit.getAmount();
        Storage.storage.put(fruitFromStorage, amountAfter);
    }
}
