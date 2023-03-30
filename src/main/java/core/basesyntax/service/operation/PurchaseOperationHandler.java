package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = FruitStorage.fruitStorage.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Don't have enough fruits.");
        }
        FruitStorage.fruitStorage.put(fruitTransaction.getFruit(), quantity);
    }
}
