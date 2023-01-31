package core.basesyntax.transaction;

import core.basesyntax.model.Fruit;

public class SetBalanceTransaction implements TransactionHandler {
    @Override
    public Fruit callTransaction(Fruit fruit, int amount) {
        fruit.setAmount(amount);
        return fruit;
    }
}
