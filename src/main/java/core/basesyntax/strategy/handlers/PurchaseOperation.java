package core.basesyntax.strategy.handlers;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        fruitStorage.purchaseItem(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
