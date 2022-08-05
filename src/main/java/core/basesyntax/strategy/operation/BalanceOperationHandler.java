package core.basesyntax.strategy.operation;

import core.basesyntax.service.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        addToBalance(transaction);
    }
}
