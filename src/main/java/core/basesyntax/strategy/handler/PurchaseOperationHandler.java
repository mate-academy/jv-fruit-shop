package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseOperationHandler implements OperationStrategy {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.STORAGE.get(fruitName) < fruitQuantity) {
            throw new RuntimeException("The amount of fruits in Storage is less"
                    + " then you are trying to purchase: " + fruitQuantity);
        }
        Storage.STORAGE.put(fruitName,
                Storage.STORAGE.get(fruitName) - fruitQuantity);
    }
}
