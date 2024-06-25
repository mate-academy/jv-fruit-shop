package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    private static final int MINIMUM_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() <= MINIMUM_QUANTITY) {
            throw new RuntimeException("Purchase must be 1 or more items. But was: "
                    + transaction.getQuantity());
        }
        int result = Storage.getQuantity(transaction.getFruitName()) - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("There is no required quantity in stock.Exist: "
                    + Storage.getQuantity(transaction.getFruitName()) + "Required: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(),
                result);
    }
}
