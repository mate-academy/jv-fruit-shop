package core.basesyntax.transaction;

import core.basesyntax.model.Fruit;

public class SupplyFruitTransaction implements TransactionHandler {
    @Override
    public Fruit callTransaction(Fruit fruit, int amount) {
        fruit.setAmount(fruit.getAmount() + amount);
        return fruit;
    }
}
