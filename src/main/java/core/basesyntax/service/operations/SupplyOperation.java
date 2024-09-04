package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
            int newValue = Storage.fruits.get(transaction.getFruit())
                    + transaction.getQuantity();
            Storage.fruits.put(transaction.getFruit(), newValue);
        }
    }
}
