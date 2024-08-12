package core.basesyntax.service.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Fruit fruit) {
        fruit.setQuantity(fruit.getQuantity() - fruitTransaction.getTransactionQuantity());
    }
}
