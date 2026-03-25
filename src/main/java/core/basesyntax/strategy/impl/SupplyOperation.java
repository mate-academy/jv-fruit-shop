package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction, Storage storage) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
