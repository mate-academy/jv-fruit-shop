package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MIN_QUANTITY) {
            throw new RuntimeException("Purchase must be 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        if ((getCurrentBalance(transaction) - transaction.getQuantity()) < 0) {
            throw new RuntimeException("There is no required quantity in stock.Exist: "
                    + getCurrentBalance(transaction) + "Required: "
                    + transaction.getQuantity());
        }
        Storage.reports.put(transaction.getFruitName(),
                getCurrentBalance(transaction) - transaction.getQuantity());
    }
}
