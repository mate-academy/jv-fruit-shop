package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void updateAmount(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Fruit quantity cannot be negative!");
        }
        Storage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
