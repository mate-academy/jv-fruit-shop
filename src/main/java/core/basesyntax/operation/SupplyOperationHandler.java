package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void applyTransactionToStorage(FruitTransaction fruitTransaction) {
        int amount = fruitTransaction.getAmount();
        if (amount < 0) {
            throw new RuntimeException("You can't supply with negative amount");
        }
        Storage.fruits.put(fruitTransaction.getFruit(),
                Storage.fruits.get(fruitTransaction.getFruit()) + amount);
    }
}
