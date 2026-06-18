package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.addOrUpdate(transaction.getFruit(), transaction.getQuantity());
    }
}
