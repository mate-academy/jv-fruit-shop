package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getFruit(), transaction.getAmount());
    }
}
