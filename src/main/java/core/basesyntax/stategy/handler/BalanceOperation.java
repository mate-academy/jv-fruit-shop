package core.basesyntax.stategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruitName(), transaction.getQuantity());
    }
}
