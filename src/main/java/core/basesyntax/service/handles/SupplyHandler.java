package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(),
                Integer::sum);
    }
}

