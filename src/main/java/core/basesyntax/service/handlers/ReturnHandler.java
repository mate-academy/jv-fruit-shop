package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Integer quantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(), quantity + transaction.getQuantity());
    }
}
