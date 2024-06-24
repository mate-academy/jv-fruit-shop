package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() < MIN_QUANTITY) {
            throw new RuntimeException("Balance can`t be negative.Actual: "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruitName(), transaction.getQuantity());
    }
}
