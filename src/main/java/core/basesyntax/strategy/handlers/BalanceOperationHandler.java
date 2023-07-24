package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitStorage.FRUITS.put(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public Operation getOperationType() {
        return Operation.BALANCE;
    }

}
