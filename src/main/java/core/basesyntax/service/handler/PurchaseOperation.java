package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Fruit fruit) {
        fruit.setQuantity(fruit.getQuantity() - fruitTransaction.getTransactionQuantity());
    }
}
