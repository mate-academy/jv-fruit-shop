package core.basesyntax.strategy.operations.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void proccessOperation(Transaction transaction) {
        Storage.REPORT.put(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s", this.getClass().getSimpleName());
    }
}
