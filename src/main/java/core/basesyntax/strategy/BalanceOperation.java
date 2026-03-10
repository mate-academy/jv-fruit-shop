package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        validateTransaction(fruitTransaction);
        Storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
