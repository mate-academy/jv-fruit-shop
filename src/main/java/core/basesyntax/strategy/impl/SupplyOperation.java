package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int current = Storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        Storage.getFruits().put(transaction.getFruit(), current + transaction.getQuantity());
    }
}
