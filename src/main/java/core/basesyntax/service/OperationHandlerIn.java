package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerIn implements OperationHandler {

    private int value = 0;

    @Override
    public void handle(FruitTransaction transaction) {
        value = Storage.result.get(transaction.getFruit());
        Storage.result.put(transaction.getFruit(), value
                + transaction.getQuantity());
    }
}
