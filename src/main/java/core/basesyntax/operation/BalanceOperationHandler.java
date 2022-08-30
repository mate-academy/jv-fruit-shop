package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
