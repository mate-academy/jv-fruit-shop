package core.basesyntax.service.operation;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation(String operation) {
        return FruitTransaction.Operation.PURCHASE;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (Storage.fruits.containsKey(transaction.getFruit())) {
            Storage.fruits.put(transaction.getFruit(),
                    Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            Storage.fruits.put(transaction.getFruit(),transaction.getQuantity());
        }
    }
}
