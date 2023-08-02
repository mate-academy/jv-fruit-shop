package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction can`t be null");
        }

        String fruitName = fruitTransaction.getFruit();
        int supplyQuantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.fruitStorage.get(fruitName);

        Storage.fruitStorage.put(fruitName, currentQuantity + supplyQuantity);
    }
}
