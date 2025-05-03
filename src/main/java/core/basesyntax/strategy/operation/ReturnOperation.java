package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public int makeOperation(FruitTransaction transaction, int storedAmount) {
        return storedAmount + transaction.getQuantity();
    }
}
