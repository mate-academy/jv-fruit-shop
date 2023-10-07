package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitTransaction.setAmount(fruitTransaction.getAmount());
    }
}
