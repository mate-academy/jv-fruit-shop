package core.basesyntax.service.operationhandlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.FRUIT_STORAGE.put(transaction.getFruit(),transaction.getAmount());
    }
}
