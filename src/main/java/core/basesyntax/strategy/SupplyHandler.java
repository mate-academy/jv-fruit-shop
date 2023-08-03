package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.IllegalQuantityException;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int supplyQuantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.fruitStorage.get(fruitName);

        if (supplyQuantity < 0) {
            throw new IllegalQuantityException("Transaction \"supply\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, currentQuantity + supplyQuantity);
    }
}
