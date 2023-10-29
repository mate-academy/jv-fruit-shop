package core.basesyntax.strategy.operations.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void proccessOperation(Transaction transaction) {
        Integer currentValue = Storage.REPORT.get(transaction.getFruit());
        if (currentValue < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruit to sell");
        }
        Storage.REPORT.put(transaction.getFruit(), currentValue - transaction.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s", this.getClass().getSimpleName());
    }
}
