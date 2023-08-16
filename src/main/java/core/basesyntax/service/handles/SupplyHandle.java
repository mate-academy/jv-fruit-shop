package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandle;

public class SupplyHandle implements OperationHandle {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(),
                Integer::sum);
    }
}

