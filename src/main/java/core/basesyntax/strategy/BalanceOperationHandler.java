package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
