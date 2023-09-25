package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class OperationHandlerOut implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        int value = Storage.storage.get(transaction.getFruit());
        if (value - transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance can`t be less then zero");
        }
        Storage.storage.put(transaction.getFruit(),
                value - transaction.getQuantity());
    }
}
