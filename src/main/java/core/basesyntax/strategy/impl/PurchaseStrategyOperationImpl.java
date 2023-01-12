package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseStrategyOperationImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int purchaseQuantity = transaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName);
        Storage.fruits.put(fruitName, oldQuantity - purchaseQuantity);
    }
}
