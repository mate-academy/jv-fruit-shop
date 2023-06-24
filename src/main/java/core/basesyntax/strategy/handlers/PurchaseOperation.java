package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.handlers.FruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int pastValue = Storage.fruits.get(transaction.getFruit());
        if (pastValue >= transaction.getQuantity()) {
            Storage.fruits.put(transaction.getFruit(), pastValue - transaction.getQuantity());
        } else {
            throw new FruitTransactionException("Value of " + transaction.getFruit()
                    + " less than " + transaction.getQuantity() + " in storage");
        }
    }
}
