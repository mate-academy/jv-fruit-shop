package core.basesyntax.strategy.operations.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void proccessOperation(Transaction transaction) {
        int currentValue = Storage.REPORT.get(transaction.getFruit());
        Storage.REPORT.put(transaction.getFruit(), currentValue + transaction.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s", this.getClass().getSimpleName());
    }
}
