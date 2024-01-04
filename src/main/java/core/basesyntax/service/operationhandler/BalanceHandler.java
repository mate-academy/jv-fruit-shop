package core.basesyntax.service.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
