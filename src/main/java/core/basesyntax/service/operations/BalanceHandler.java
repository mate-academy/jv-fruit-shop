package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
