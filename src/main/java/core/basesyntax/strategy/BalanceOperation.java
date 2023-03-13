package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationStrategy {

    @Override
    public void execute(String fruit, int quantity) {
        Storage.getFruitShop().put(fruit, quantity);
    }
}
