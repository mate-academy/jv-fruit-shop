package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class SupplyOperationHandler implements OperationStrategy {
    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruitName, Storage.STORAGE.get(fruitName) + fruitQuantity);
    }
}
