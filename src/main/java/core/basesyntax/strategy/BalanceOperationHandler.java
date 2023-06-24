package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruitsStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
