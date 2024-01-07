package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceStrategy implements OperationStrategy {

    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        storage.getFruitQuantities().put(fruit, quantity);
    }
}
