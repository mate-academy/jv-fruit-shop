package core.basesyntax.service.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Fruit fruit) {
        fruit.setQuantity(fruitTransaction.getTransactionQuantity());
    }
}
