package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.quantities.put(transaction.getFruit(),
                Storage.quantities
                        .merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum));
    }
}
