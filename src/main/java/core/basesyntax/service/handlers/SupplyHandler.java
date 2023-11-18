package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class SupplyHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(),
                Integer::sum);
    }
}
