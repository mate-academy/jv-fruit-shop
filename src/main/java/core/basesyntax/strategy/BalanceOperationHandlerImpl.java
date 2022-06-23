package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        Storage.storageMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
