package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void applyOperation(Transaction transaction) {
        Integer amount = Storage.fruits.get(transaction.getFruit())
                + transaction.getAmount();
        Storage.fruits.replace(transaction.getFruit(), amount);
    }
}
