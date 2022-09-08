package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void getOperationHandler(FruitTransaction transaction) {
        Storage.storageFruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
