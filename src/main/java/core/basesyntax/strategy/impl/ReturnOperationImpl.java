package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MIN_QUANTITY) {
            throw new RuntimeException("You must return 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruitName(),
                transaction.getQuantity() + getCurrentBalance(transaction));
    }
}
