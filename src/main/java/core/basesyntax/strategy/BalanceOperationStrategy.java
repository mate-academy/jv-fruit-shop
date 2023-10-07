package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitTransaction.setAmount(fruitTransaction.getAmount());
    }
}
