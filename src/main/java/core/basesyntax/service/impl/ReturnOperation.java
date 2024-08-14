package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.quantities.put(transaction.getFruit(),
                Storage.quantities
                        .getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
