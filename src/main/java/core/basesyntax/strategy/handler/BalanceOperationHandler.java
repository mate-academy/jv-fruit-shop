package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruitName(), transaction.getQuantity());
    }
}
