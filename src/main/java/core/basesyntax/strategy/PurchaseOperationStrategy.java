package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitTransaction.setAmount(-fruitTransaction.getAmount());
    }
}
