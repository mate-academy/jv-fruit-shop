package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        FruitStorage.storage.merge(transaction.getProductName(),
                transaction.getQuantity(), Integer::sum);
    }
}
