package core.basesyntax.transaction;

import core.basesyntax.model.Fruit;

public class PurchaseTransaction implements TransactionHandler {
    @Override
    public Fruit callTransaction(Fruit fruit, int amount) {
        fruit.setAmount(fruit.getAmount() - amount);
        return fruit;
    }
}
