package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        // someone has bought some fruits
        if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
            int newValue = Storage.fruits.get(transaction.getFruit())
                    - transaction.getQuantity();
            if (newValue < 0) {
                throw new RuntimeException("Result can't be negative number");
            }
            Storage.fruits.put(transaction.getFruit(), newValue);
        }
    }
}
