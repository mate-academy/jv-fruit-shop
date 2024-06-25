package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private static final int MINIMUM_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MINIMUM_QUANTITY) {
            throw new RuntimeException("Supplier must supply 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(),
                Storage.getQuantity(transaction.getFruitName())
                        + transaction.getQuantity());
    }
}
