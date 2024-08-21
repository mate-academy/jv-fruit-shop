package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import static core.basesyntax.storage.Storage.fruits;

public class BalanceOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        fruits.replace(fruitTransaction.getFruitName(), fruitTransaction.getTransactionQuantity());
    }
}
