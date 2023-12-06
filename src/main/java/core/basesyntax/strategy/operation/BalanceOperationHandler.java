package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int get(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
