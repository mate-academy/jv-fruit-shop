package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
