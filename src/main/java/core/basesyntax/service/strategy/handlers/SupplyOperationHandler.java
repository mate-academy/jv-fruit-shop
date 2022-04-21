package core.basesyntax.service.strategy.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        Storage.addToDataBase(fruitTransaction.getFruit(),
                Storage.getByKey(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
