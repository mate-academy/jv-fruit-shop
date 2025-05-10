package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.fruits.get(transaction.getFruit());
        if (currentValue > transaction.getQuantity()) {
            Storage.fruits.put(transaction.getFruit(),
                    currentValue - transaction.getQuantity());
        } else {
            throw new RuntimeException(
                    "There are no enough " + transaction.getFruit() + "s"
                    + System.lineSeparator()
                    + "Balance: " + currentValue
            );
        }
    }
}
