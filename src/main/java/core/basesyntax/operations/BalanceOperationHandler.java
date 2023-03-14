package core.basesyntax.operations;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
