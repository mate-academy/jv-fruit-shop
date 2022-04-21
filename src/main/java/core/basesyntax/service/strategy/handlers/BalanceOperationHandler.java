package core.basesyntax.service.strategy.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        Storage.addToDataBase(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
