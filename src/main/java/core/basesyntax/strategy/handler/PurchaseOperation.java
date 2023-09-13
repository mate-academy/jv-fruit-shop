package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseOperation implements OperationStrategy {
    @Override
    public void makeFruitTransactionOperation(FruitTransaction fruitTransaction) {
        if (Storage.STORAGE.get(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("The amount of fruits in Storage is less"
                    + " then you are trying to purchase: " + fruitTransaction.getQuantity());
        }
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                Storage.STORAGE.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
