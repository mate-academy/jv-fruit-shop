package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class BalanceHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
