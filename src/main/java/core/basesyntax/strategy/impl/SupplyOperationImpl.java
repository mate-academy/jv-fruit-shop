package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MIN_QUANTITY) {
            throw new RuntimeException("Supplier must supply 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruitName(),
                getCurrentBalance(transaction) + transaction.getQuantity());
    }
}
