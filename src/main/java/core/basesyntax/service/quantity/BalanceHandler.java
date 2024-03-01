package core.basesyntax.service.quantity;

import core.basesyntax.entity.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public FruitTransaction getTransitionTransaction(FruitTransaction fruitTransaction) {
        return fruitTransaction;
    }
}
