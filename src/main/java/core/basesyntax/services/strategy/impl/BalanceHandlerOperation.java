package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class BalanceHandlerOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        DataStorage.fruitsStorageMap.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
