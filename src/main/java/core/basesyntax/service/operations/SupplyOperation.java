package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (Storage.fruits.containsKey(transaction.getFruit())
                && transaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
            int newValue = new Storage().getQuantity(transaction.getFruit())
                    + transaction.getQuantity();
            Storage.fruits.put(transaction.getFruit(), newValue);
        }
    }
}
