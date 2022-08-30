package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
