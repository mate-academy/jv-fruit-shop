package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Integer actualAmount = Storage.storage.get(fruitTransaction.getNameOfObject());
        if (actualAmount != null) {
            Storage.storage.put(fruitTransaction.getNameOfObject(),
                    actualAmount + fruitTransaction.getAmount());
        } else {
            Storage.storage.put(fruitTransaction.getNameOfObject(),
                    fruitTransaction.getAmount());
        }
    }
}
