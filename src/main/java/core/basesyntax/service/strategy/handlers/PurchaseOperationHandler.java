package core.basesyntax.service.strategy.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.NotEnoughFruitsInStorage;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        if (Storage.getByKey(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new NotEnoughFruitsInStorage("Can't do this operation");
        }
        Storage.addToDataBase(fruitTransaction.getFruit(),
                Storage.getByKey(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
