package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class OperationHandlerIn implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        int value = Storage.result.get(transaction.getFruit());
        Storage.result.put(transaction.getFruit(), value
                + transaction.getQuantity());
    }
}
